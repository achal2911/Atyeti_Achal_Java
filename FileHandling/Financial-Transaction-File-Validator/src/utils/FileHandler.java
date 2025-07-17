package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

public class FileHandler
{
   static final Logger logger = Logger.getLogger(FileHandler.class.getName());

    public static void moveFileToDirectory(File file, String directoryPath) {
        File targetDir = new File(directoryPath);
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        File targetFile = new File(targetDir, file.getName());
        try {
            Files.move(file.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            logger.info("Moved " + file.getName() + " to directory: " + directoryPath);
        } catch (IOException e) {
            logger.warning("Failed to move file " + file.getName() + ": " + e.getMessage());
        }
    }


}
