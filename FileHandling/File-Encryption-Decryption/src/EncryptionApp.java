import javax.crypto.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class EncryptionApp {
    static Logger logger = Logger.getLogger(EncryptionApp.class.getName());

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, IOException, BadPaddingException, InvalidKeyException {

        String inputFile = "C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\FileHandling\\File-Encryption-Decryption\\src\\inputFile.csv";
        String encryptedFile = "C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\FileHandling\\File-Encryption-Decryption\\src\\encryptedFile.csv";
        String decryptedFile = "C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\FileHandling\\File-Encryption-Decryption\\src\\decryptedFile.csv";


        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);

        SecretKey secretKey = keyGenerator.generateKey();


        FileEncryptor.encryptFile(inputFile, encryptedFile, secretKey);
        logger.info("file encrypted successfully!!");

        FileDecryptor.decryptFile(encryptedFile, decryptedFile, secretKey);
        logger.info("file decrypted successfully!!");
    }
}