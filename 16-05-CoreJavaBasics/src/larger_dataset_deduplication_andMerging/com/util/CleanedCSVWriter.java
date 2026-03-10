package larger_dataset_deduplication_andMerging.com.util;

import larger_dataset_deduplication_andMerging.com.model.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CleanedCSVWriter {

    public static void writingOfCleanedDataToCSVFile(List<Person> cleanedData ,String filePath) throws IOException {
        BufferedWriter writer=new BufferedWriter(new FileWriter(filePath));
        writer.write("ID,Name,Email,Phone\n");

        for (int i = 0; i < cleanedData.size(); i++) {
            writer.write(cleanedData.get(i).toString()+"\n");
        }

        writer.close();

        System.out.println("Clean Data Written Successfully");
    }
}
