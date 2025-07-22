package utils;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileEncryptor {
    public static void encryptFile(File inputFile, File outputFile, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        FileInputStream fis = new FileInputStream(inputFile);
        byte[] inputBytes = fis.readAllBytes();
        fis.close();

        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        FileOutputStream fos = new FileOutputStream(outputFile);
        fos.write(encryptedBytes);
        fos.close();
    }
}

