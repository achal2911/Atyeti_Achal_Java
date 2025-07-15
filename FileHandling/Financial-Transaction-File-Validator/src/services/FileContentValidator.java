package services;

import config.ValidationConfig;

public class FileContentValidator {


    public static boolean isValidRow(String row) {
        if (row == null || row.trim().isEmpty()) return false;

        String[] fields = row.split(",");
        if (fields.length != 6) return false;

        for (String field : fields) {
            if (field.trim().isEmpty()) return false;
        }

        return true;
    }

    public static boolean isValidHeader(String header) {
        if (header == null || header.isBlank()) return false;

        return header.split(",", -1).length == 6 &&
                header.equalsIgnoreCase(ValidationConfig.EXPECTED_HEADER);
    }


}
