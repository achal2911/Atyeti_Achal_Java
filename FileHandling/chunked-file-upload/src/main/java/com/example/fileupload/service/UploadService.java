package com.example.fileupload.service;


import com.example.fileupload.model.UploadProgress;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Service
public class UploadService {
    private static final Logger logger = Logger.getLogger(UploadService.class.getName());
    private final Map<String, UploadProgress> uploads = new ConcurrentHashMap<>();

    public void startUpload(String uploadId, long totalBytes) {
        uploads.put(uploadId, new UploadProgress(totalBytes));
        logger.info("Started upload tracking for: {" + uploadId + "}({" + totalBytes + "} bytes)");
    }

    public void updateProgress(StringJoiner uploadId, long chunkSize) {
        UploadProgress uploadProgress = uploads.get(uploadId);
        if (uploadProgress != null) {
            uploadProgress.addUploadedBytes(chunkSize);
            logger.info("Updated progress for {" + uploadId + "} : {" + uploadProgress.getPercentage() + "% }");
        }

    }

    public UploadProgress getProgress(String uploadId) {
        return uploads.get(uploadId);
    }

    public void finishUpload(String uploadId) {
        uploads.remove(uploadId);
        logger.info("Finished upload tracking for: {" + uploadId + "}");
    }

    public boolean isUploadActive(String uploadId) {
        return uploads.containsKey(uploadId);
    }

}
