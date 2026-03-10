package collections_and_streams.employee_management_system.service;

import collections_and_streams.employee_management_system.model.Employees;

import java.util.*;
import java.util.stream.Collectors;

public class ManagingEmployeeData {

    public static void findAllEmployeeByDepartment(String department, List<Employees> employees) {
        List<Employees> filteredEmployees = employees.stream().filter(x->x.getDepartment().equalsIgnoreCase(department)).toList();

        if (filteredEmployees.isEmpty()) {
            System.out.println("No employees found in department: " + department);
        } else {
            System.out.println("Employees in department: " + department);
            filteredEmployees.forEach(System.out::println);
        }
    }

    public static void sortEmpInDecreasingOrderBySalary(List<Employees> employees)
    {
        List<Employees> sortedlist = employees.stream().sorted((x, y) -> (int) (y.getSalary() - x.getSalary())).toList();

        sortedlist.forEach(System.out::println);

    }


    public static void removeDuplicatesBasedOnId(List<Employees> employeeList) {

        List<Employees> uniqueEmployeeData = employeeList.stream().distinct().toList();
        if(!uniqueEmployeeData.isEmpty())
        {
            uniqueEmployeeData.forEach(System.out::println);
        }
        else {
            System.out.println("No duplicate employee found !!");

        }
    }


    public static void groupOfEmployeesByDepartment(List<Employees> employeeList) {

        Map<String, List<Employees>> groupOfEmployees = employeeList.stream().collect(Collectors.groupingBy(Employees::getDepartment));
        Set<Map.Entry<String, List<Employees>>> entries= groupOfEmployees.entrySet();

        for(Map.Entry<String, List<Employees>>entry : entries)
        {

            System.out.println("DEPARTMENT:"+entry.getKey()+" \n "+"EmployeesList:"+entry.getValue());

        }


    }
}
