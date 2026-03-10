import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileDecryptor {
    public static void decryptFile(String inputFilepath, String outFilepath, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        FileInputStream inputStream = new FileInputStream(inputFilepath);
        byte[] inputBytes = new byte[(int) new File(inputFilepath).length()];
        inputStream.read(inputBytes);

        byte[] decryptedBytes = cipher.doFinal(inputBytes);
        FileOutputStream outputStream = new FileOutputStream(outFilepath);
        outputStream.write(decryptedBytes);

        inputStream.close();
        outputStream.close();

    }
}
