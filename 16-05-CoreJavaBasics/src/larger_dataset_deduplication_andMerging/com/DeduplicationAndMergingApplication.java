package larger_dataset_deduplication_andMerging.com;

import larger_dataset_deduplication_andMerging.com.model.Person;
import larger_dataset_deduplication_andMerging.com.util.CSVReaderUtils;
import larger_dataset_deduplication_andMerging.com.util.CleanedCSVWriter;

import java.io.IOException;
import java.util.List;

public class DeduplicationAndMergingApplication {
    public static void main(String[] args) throws IOException {

        String csvData1Filepath="C:\\Users\\Achal Tikale\\IdeaProjects\\Atyeti_Achal_Java\\16-05-CoreJavaBasics\\src\\larger_dataset_deduplication_andMerging\\com\\data\\data1.csv";
        String csvData2Filepath="C:\\Users\\Achal Tikale\\IdeaProjects\\Atyeti_Achal_Java\\16-05-CoreJavaBasics\\src\\larger_dataset_deduplication_andMerging\\com\\data\\data2.csv";
        String cleanedCSVDataFilepath="C:\\Users\\Achal Tikale\\IdeaProjects\\Atyeti_Achal_Java\\16-05-CoreJavaBasics\\src\\larger_dataset_deduplication_andMerging\\com\\data\\cleanedData\\cleanedDataCSV.csv";

        //reading of csv data from 2 files
        List<Person> csvData1List= CSVReaderUtils.readingOfCSVData(csvData1Filepath);
        List<Person> csvData2List= CSVReaderUtils.readingOfCSVData(csvData2Filepath);

        //merging of two csv data files
        List<Person> mergedCSVDataList= CSVReaderUtils.mergingOfTwoCSVDataFiles(csvData1List, csvData2List);

        //cleaning of duplicate data by using either email or phone
        List<Person> cleanedUniqueDataByEmailOrPhone = CSVReaderUtils.cleaningDuplicateDataInMergedCSVDatafiles(mergedCSVDataList);

        //writing of cleaned data in new csv file
        CleanedCSVWriter.writingOfCleanedDataToCSVFile(cleanedUniqueDataByEmailOrPhone,cleanedCSVDataFilepath);

    }
}
