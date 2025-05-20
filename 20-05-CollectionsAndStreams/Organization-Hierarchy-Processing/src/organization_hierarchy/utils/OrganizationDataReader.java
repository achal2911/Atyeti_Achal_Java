package organization_hierarchy.utils;

import organization_hierarchy.model.EmployeeData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationDataReader {

    public static List<EmployeeData> readEmployeeData(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        ArrayList<EmployeeData> employees = new ArrayList<>();
        String line="";

        line= bufferedReader.readLine();
        while ((line=bufferedReader.readLine())!=null)
        {
            String[] split = line.split(",");
            String employeeId=split[0];
            String employeeName=split[1];
            String managerId=((split[2].isEmpty()||split[2].equalsIgnoreCase("null"))?null:split[2]);
            double salary=Double.parseDouble(split[4]);
            EmployeeData employeeData = new EmployeeData(employeeId,employeeName,managerId,salary);
           employees.add(employeeData);
        }

        return employees;

    }
//sas

}
