package employeedata_analytics_withstreams;

import employeedata_analytics_withstreams.model.Employee;
import employeedata_analytics_withstreams.util.EmployeeUtility;
import employeedata_analytics_withstreams.util.FileUtility;

import java.util.List;
import java.util.logging.Logger;

public class EmployeeDataAnalyzer {


    public static void main(String[] args) {
        String employeeDataFilepath = "C:\\Users\\AchalTikale\\IdeaProjects\\Atyeti_Achal_Java\\streams\\src\\employeedata_analytics_withstreams\\util\\empdata.csv";

        List<Employee> employeeList = FileUtility.employeeDataReader(employeeDataFilepath);

        EmployeeUtility util = new EmployeeUtility();


        System.out.println("1.Gender Count: " + util.getGenderCount(employeeList));
        System.out.println("2.All Departments: " + util.getAllDepartments(employeeList));
        System.out.println("3.Average Age by Gender: " + util.getAverageAgeByGender(employeeList));
        System.out.println("4.Highest Paid Employee: " + util.getHighestPaidEmployee(employeeList));

        System.out.println("5.Employees  Name Joined After 2015:");
        util.getEmployeesJoinedAfter2015(employeeList);

        System.out.println("6.Employee Count by Department: " + util.getEmployeeCountByDepartment(employeeList));
        System.out.println("7.Average Salary by Department: " + util.getAverageSalaryByDepartment(employeeList));
        System.out.println("8.Youngest Male in Development: " + util.getYoungestMaleInDevelopment(employeeList));

        System.out.println("9.Most Experienced Employee: " + util.getMostExperiencedEmployee(employeeList));
        System.out.println("10.Gender Count in Sales: " + util.getGenderCountInSales(employeeList));

        System.out.println("11.Total & Average Salary: " + EmployeeUtility.getAverageAndTotalSalary(employeeList));

        System.out.println("12.Partition By Age:");
        util.partitionByAge25(employeeList);

        System.out.println("13.Oldest Employee: " + util.getOldestEmployee(employeeList));
    }

}

