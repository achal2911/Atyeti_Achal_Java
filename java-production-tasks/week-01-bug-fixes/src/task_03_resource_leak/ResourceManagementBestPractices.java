package task_03_resource_leak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ResourceManagementBestPractices
{
/*
* // RESOURCE LEAK - Files not closed properly
public String readFile(String filename) {
try {
FileReader file = new FileReader(filename);
BufferedReader reader = new BufferedReader(file);
return reader.readLine();
} catch (IOException e) {
return "Error reading file";
}
// Resources never closed!
}*/

    public static String readFile(String filename)
    {
        if (filename == null || filename.trim().isEmpty()) {
            return "Invalid filename";
        }
        try(FileReader reader=new FileReader(filename);
            BufferedReader bufferedReader=new BufferedReader(reader)) {

            return bufferedReader.readLine();

        } catch (FileNotFoundException e) {
            return "File not found: " + filename;
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
    public static void main(String[] args) {

        String file="C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\java-production-tasks\\week-01-bug-fixes\\src\\task_03_resource_leak\\resource.txt";
        System.out.println(readFile(file));

    }
}
