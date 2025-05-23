package organization_hierarchy;

import organization_hierarchy.model.EmployeeData;
import organization_hierarchy.service.EmployeeService;
import organization_hierarchy.utils.OrganizationDataReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OrganizationHierarchyProcessingMain {
    public static void main(String[] args) throws IOException {

        String employeesDataFilepath="C:\\Users\\AchalTikale\\OneDrive - Atyeti Inc\\IdeaProjects\\java\\20-05-CollectionsAndStreams\\Organization-Hierarchy-Processing\\src\\organization_hierarchy\\utils\\employee_data.csv";
        List<EmployeeData> employeeDataList= OrganizationDataReader.readEmployeeData(employeesDataFilepath);
        //employeeDataList.forEach(System.out::println);
        System.out.println("----------------------------------------------------");


        // lists employees under a specific manager by manger Name.
        Map<String, List<EmployeeData>>listEmployeesUnderManager =EmployeeService.listEmployeesUnderManager(employeeDataList);
        listEmployeesUnderManager.forEach((managerName,listOfEmployees)->
                System.out.println("Manager Name:"+managerName+", \n"+"List Of Employee Working Under above Manager:\n"+listOfEmployees)
        );
        System.out.println("----------------------------------------------------");

        //Find the average salary of each manager’s team.
        Map<String, Double> averageSalaryOfTeamPerManager= EmployeeService.calculateAverageSalaryPerManager(employeeDataList);
        averageSalaryOfTeamPerManager.forEach((x,y)-> System.out.println("Manager Name:->"+x +"\nAverage Salary Of team:->"+y));
        System.out.println("----------------------------------------------------");

        //top 3 departments by total team salary.
        System.out.println("top 3 departments by total team salary:");
        Map<String, Double> topThreeDepartment = EmployeeService.topThreeDepartmentSalary(employeeDataList);
        topThreeDepartment.forEach((x,y)-> System.out.println("Department Name:->"+x +"\nAverage Salary Of team under department:->"+y));


    }
}
