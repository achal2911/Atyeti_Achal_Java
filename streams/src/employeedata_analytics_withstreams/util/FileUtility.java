package employeedata_analytics_withstreams.util;

import employeedata_analytics_withstreams.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    public static List<Employee> employeeDataReader(String filepath) {
        List<Employee> employeeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {

            String line = "";
            br.readLine();
            while ((line = br.readLine()) != null) {

                Employee employee = getEmployee(line);

                employeeList.add(employee);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employeeList;

    }

    private static Employee getEmployee(String line) {
        String[] split = line.split(",");
        int id = Integer.parseInt(split[0]);
        String name = split[1];
        int age = Integer.parseInt(split[2]);
        String gender = split[3];
        String department = split[4];
        int yearOfJoining = Integer.parseInt(split[5]);
        double salary = Double.parseDouble(split[6]);
        return new Employee(id, name, age, gender, department, yearOfJoining, salary);
    }
}
