import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileEncryptor
{
    public  static  void encryptFile(String inputFilepath, String outFilepath, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher=Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);

        FileInputStream inputStream=new FileInputStream(inputFilepath);
        byte[]inputBytes=new byte[(int)new File(inputFilepath).length()];
        inputStream.read(inputBytes);

        byte[] encryptedBytes = cipher.doFinal(inputBytes);
        FileOutputStream outputStream=new FileOutputStream(outFilepath);
        outputStream.write(encryptedBytes);

        inputStream.close();
        outputStream.close();
    }
}
