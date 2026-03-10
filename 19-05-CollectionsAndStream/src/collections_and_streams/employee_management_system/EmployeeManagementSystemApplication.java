package collections_and_streams.employee_management_system;


import collections_and_streams.employee_management_system.model.Employees;
import collections_and_streams.employee_management_system.service.EmployeesDataReader;
import collections_and_streams.employee_management_system.service.ManagingEmployeeData;

import java.io.IOException;
import java.util.List;

public class EmployeeManagementSystemApplication {
    public static void main(String[] args) throws IOException {

        String employeeDataFilepath = "C:\\Users\\Achal Tikale\\IdeaProjects\\Atyeti_Achal_Java\\19-05-CollectionsAndStream\\src\\collections_and_streams\\employee_management_system\\util\\employee_data_with_duplicates.txt";
        List<Employees> employeeList = EmployeesDataReader.readEmployeeData(employeeDataFilepath);


        //Find all employees in a specific department.
        ManagingEmployeeData.findAllEmployeeByDepartment("it", employeeList);

        System.out.println("-----------------------------------");

        //Sort employees by salary in descending order.
        System.out.println("list of employees by salary in descending order:");
        ManagingEmployeeData.sortEmpInDecreasingOrderBySalary(employeeList);

        System.out.println("-----------------------------------");

        //Remove duplicate employees based on ID.
        System.out.println("Employees list after removing duplicate  based on ID:");
        ManagingEmployeeData.removeDuplicatesBasedOnId(employeeList);

        System.out.println("-----------------------------------");

        //Group employees by department.
        ManagingEmployeeData.groupOfEmployeesByDepartment(employeeList);

    }
}
