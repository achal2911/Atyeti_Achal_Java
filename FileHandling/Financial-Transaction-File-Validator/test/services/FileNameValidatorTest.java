package services;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileNameValidatorTest {

    @Test
    public void shouldReturnTrueForValidFileNameWithCurrentOrAllowedDate() {
        assertTrue(FileNameValidator.isValidFileName("ABC123_TXN_20250724.csv"));
    }

    @Test
    public void shouldReturnFalseForFileNameWithInvalidFormat() {
        assertFalse(FileNameValidator.isValidFileName("invalid.csv"));
    }

    @Test
    public void shouldReturnFalseForValidFormatButInvalidDate() {
        assertFalse(FileNameValidator.isValidFileName("ABC123_TXN_20200101.csv"));
    }
}
