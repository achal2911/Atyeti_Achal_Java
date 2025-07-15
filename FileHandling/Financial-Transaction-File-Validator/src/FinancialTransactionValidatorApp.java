import services.FileNameValidator;

import java.io.File;
import java.util.logging.Logger;

public class FinancialTransactionValidatorApp
{
    public static void main(String[] args)
    {
        String directoryPath="C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\FileHandling\\Financial-Transaction-File-Validator\\directory";



        File inputDirectory=new File(directoryPath);

        if (!inputDirectory.exists() || !inputDirectory.isDirectory()) {
            System.out.println("Input folder not found.");
            return;
        }

        File[] files = inputDirectory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }
        for (File file : files) {
            String fileName = file.getName();
            if (FileNameValidator.isValidFileName(fileName)) {
                System.out.println("Valid file name: " + fileName);

            } else {
                System.out.println("Invalid file name: " + fileName);

            }

        }


    }
}