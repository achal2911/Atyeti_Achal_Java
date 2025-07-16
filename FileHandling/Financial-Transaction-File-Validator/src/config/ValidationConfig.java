package config;

public interface ValidationConfig
{
    String DIRECTORY_PATH ="FileHandling/Financial-Transaction-File-Validator/directory";
    String VALID_FILENAME_PATTERN_REGEX ="^[A-Z0-9]{3,}_TXN_\\d{8}\\.csv$";
    String ALLOWED_DATE = "20250715";
    String EXPECTED_HEADER = "TXN_ID,ACCOUNT_NO,TXN_DATE,AMOUNT,CURRENCY,STATUS";
    String ERROR_LOG_FILE_PATH ="C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\FileHandling\\Financial-Transaction-File-Validator\\errorLogs.txt";
}
