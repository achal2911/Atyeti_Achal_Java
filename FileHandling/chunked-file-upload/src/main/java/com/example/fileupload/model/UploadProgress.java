package com.example.fileupload.model;

public class UploadProgress {
    private long totalBytes;
    private long uploadedBytes;

    public UploadProgress(long totalBytes) {
        this.totalBytes = totalBytes;
        this.uploadedBytes = 0;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public void setTotalBytes(long totalBytes) {
        this.totalBytes = totalBytes;
    }

    public long getUploadedBytes() {
        return uploadedBytes;
    }

    public void setUploadedBytes(long uploadedBytes) {
        this.uploadedBytes = uploadedBytes;
    }

    public int getPercentage() {
        if (totalBytes == 0) return 0;
        return (int) ((uploadedBytes * 100) / totalBytes);
    }

    public synchronized void addUploadedBytes(long bytes) {
        this.uploadedBytes += bytes;
    }
}
