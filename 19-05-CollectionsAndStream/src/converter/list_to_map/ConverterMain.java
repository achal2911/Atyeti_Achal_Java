package converter.list_to_map;

import converter.list_to_map.model.Employee;
import converter.list_to_map.service.ListToMapConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConverterMain {
    public static void main(String[] args) {

        Employee employee1 = new Employee(101, "John Doe", "Software Engineer", "IT", 9876543210L);
        Employee employee2 = new Employee(102, "Jane Smith", "Project Manager", "Operations", 9123456789L);
        Employee employee3 = new Employee(103, "Alice Johnson", "Data Analyst", "Analytics", 9988776655L);
        Employee employee4 = new Employee(104, "Bob Williams", "HR Manager", "Human Resources", 9876123450L);
        Employee employee5 = new Employee(105, "Charlie Brown", "Marketing Executive", "Marketing", 9765432109L);
        Employee employee6 = new Employee(101, "John Doe", " Senior Software Engineer", "IT", 9876543210L);

        List<Employee>employeeList=new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);

        Map<Long, Employee> mappedList=ListToMapConverter.converter(employeeList);
//        System.out.println( mappedList.entrySet());

        //or

        Set<Map.Entry<Long, Employee>> entries = mappedList.entrySet();

        for(Map.Entry<Long, Employee> entry : entries)
        {
            System.out.println("Key:"+entry.getKey()+" "+"Value:"+entry.getValue());

        }

    }
}
