package config;

public interface ValidationConfig
{
    String DIRECTORY_PATH ="FileHandling/Financial-Transaction-File-Validator/directory";
    String VALID_FILENAME_PATTERN_REGEX ="^[A-Z0-9]{3,}_TXN_\\d{8}\\.csv$";
    String ALLOWED_DATE = "20250713";
}
