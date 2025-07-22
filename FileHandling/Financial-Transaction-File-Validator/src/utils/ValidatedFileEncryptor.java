package utils;

import config.ValidationConfig;

import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.util.logging.Logger;

public class ValidatedFileEncryptor
{
    private static final Logger logger = Logger.getLogger(ValidatedFileEncryptor.class.getName());

    public static void encryptAllValidatedFiles() {
        File validatedDir = new File(ValidationConfig.VALIDATED_DIRECTORY_PATH);
        File archivedDir = new File(ValidationConfig.ARCHIVED_DIRECTORY_PATH);

        if (!validatedDir.exists() || !validatedDir.isDirectory()) {
            logger.warning("Validated directory not found: " + validatedDir.getAbsolutePath());
            return;
        }

        if (!archivedDir.exists()) {
            archivedDir.mkdirs();
        }

        File[] files = validatedDir.listFiles();
        if (files == null || files.length == 0) {
            logger.info("No validated files to encrypt.");
            return;
        }

        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey secretKey=keyGenerator.generateKey();

            for (File file : files) {
                File encryptedFile = new File(archivedDir, file.getName() + ".enc");

                FileEncryptor.encryptFile(file, encryptedFile, secretKey);
                logger.info("Encrypted: " + file.getName() + " -> " + encryptedFile.getName());

                if (file.delete()) {
                    logger.info("Deleted validated file: " + file.getName());
                } else {
                    logger.warning("Failed to delete validated file: " + file.getName());
                }
            }

        } catch (Exception e) {
            logger.severe("Encryption error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
