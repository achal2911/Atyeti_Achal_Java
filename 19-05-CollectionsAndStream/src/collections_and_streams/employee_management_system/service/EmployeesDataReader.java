package collections_and_streams.employee_management_system.service;

import collections_and_streams.employee_management_system.model.Employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDataReader {
    public static List<Employees> readEmployeeData(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArrayList<Employees> employees = new ArrayList<>();
        String line="";

        line= reader.readLine();
        while ((line=reader.readLine())!=null)
        {
            String[] split = line.split(",");
            Employees employee = new Employees(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));
            employees.add(employee);
        }

        return employees;

    }
}
