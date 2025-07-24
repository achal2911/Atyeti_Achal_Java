package services;
import exception.InvalidFileException;
import org.junit.Test;
import static org.junit.Assert.*;
public class FileFieldsValidatorTest {

    @Test
    public void testValidFields() {
        String line = "ABC1234567,1234567890,2025-07-22,500.00,USD,SUCCESS";
        String fileName = "BANK_TXN_20250722.csv";
        assertTrue(FileFieldsValidator.isValidFields(line, fileName));
    }


}
