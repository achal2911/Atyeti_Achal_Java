package config;

public interface ValidationConfig {
    String DIRECTORY_PATH = "FileHandling/Financial-Transaction-File-Validator/directory";
    String VALID_FILENAME_PATTERN_REGEX = "^[A-Z0-9]{3,}_TXN_\\d{8}\\.csv$";
    String ALLOWED_DATE = "20250716";
    String EXPECTED_HEADER = "TXN_ID,ACCOUNT_NO,TXN_DATE,AMOUNT,CURRENCY,STATUS";
    String ERROR_LOG_FILE_PATH = "C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\FileHandling\\Financial-Transaction-File-Validator\\rejectedFiles_directory\\errorLogs.txt";
    String REJECTED_DIRECTORY_PATH="FileHandling/Financial-Transaction-File-Validator/rejectedFiles_directory";
    String VALIDATED_DIRECTORY_PATH="FileHandling/Financial-Transaction-File-Validator/validatedFiles_directory";
    String ARCHIVED_DIRECTORY_PATH="FileHandling/Financial-Transaction-File-Validator/archived";
    String SUMMARY_LOG_DIRECTORY_PATH="FileHandling/Financial-Transaction-File-Validator/summary_logs_directory";
}
