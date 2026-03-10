package larger_dataset_deduplication_andMerging.com.util;

import larger_dataset_deduplication_andMerging.com.model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CSVReaderUtils {

    public static List<Person> readingOfCSVData(String filePath)
    {
        List<Person>personList=new ArrayList<>();
        String line;

        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath)))
        {
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] persons =line.split(",");
                if(persons.length>=4)
                {
                    long id=Long.parseLong(persons[0]);
                    String name= persons[1];
                    String email= persons[2];
                    long phone=Long.parseLong(persons[3]);

                    Person p1=new Person(id,name,email,phone);
                    personList.add(p1);
                }
                else
                {
                    System.err.println("Invalid data entry: " + line);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }


    public static List<Person>mergingOfTwoCSVDataFiles(List<Person> csvData1,List<Person>csvData2)
    {
        csvData1.addAll(csvData2);
        return csvData1;
    }

    public static List<Person> cleaningDuplicateDataInMergedCSVDatafiles(List<Person> mergedList)
    {
        HashSet<Object> hashSet = new HashSet<>();
        mergedList.removeIf(e -> !hashSet.add(e.getEmail()) || !hashSet.add(e.getPhone()));
        return mergedList;
    }
}
