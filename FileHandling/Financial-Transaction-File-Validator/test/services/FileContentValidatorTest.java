package services;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileContentValidatorTest {

    @Test
    public void shouldReturnTrueForValidRow() {
        String validRow = "123,John,Doe,1000,USD,Active";
        assertTrue(FileContentValidator.isValidRow(validRow));
    }

    @Test
    public void shouldReturnFalseForBlankRow() {
        String blankRow = "   ";
        assertFalse(FileContentValidator.isValidRow(blankRow));
    }
}
