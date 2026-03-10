package services;

import config.ValidationConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;


public class FileNameValidator {

    private static final Pattern FILE_NAME_PATTERN =
            Pattern.compile(ValidationConfig.VALID_FILENAME_PATTERN_REGEX);

    public static boolean isValidFileName(String fileName) {

        if (!FILE_NAME_PATTERN.matcher(fileName).matches()) {
            return false;
        }

        return isDateValidFromFileName(fileName);
    }

    public static boolean isDateValidFromFileName(String fileName) {

        String dateFromFileName = fileName.substring(
                fileName.lastIndexOf("_") + 1,
                fileName.indexOf(".csv")
        );

        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        return dateFromFileName.equals(currentDate) ||
                dateFromFileName.equals(ValidationConfig.ALLOWED_DATE);
    }
}