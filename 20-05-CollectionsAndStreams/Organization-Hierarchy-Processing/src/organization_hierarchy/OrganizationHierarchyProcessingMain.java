package organization_hierarchy;

import organization_hierarchy.model.EmployeeData;
import organization_hierarchy.service.EmployeeService;
import organization_hierarchy.utils.OrganizationDataReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OrganizationHierarchyProcessingMain {
    public static void main(String[] args) throws IOException {

        String employeesDataFilepath="C:\\Users\\Achal Tikale\\IdeaProjects\\Atyeti_Achal_Java\\20-05-CollectionsAndStreams\\Organization-Hierarchy-Processing\\src\\organization_hierarchy\\utils\\employee_data.csv";
        List<EmployeeData> employeeDataList= OrganizationDataReader.readEmployeeData(employeesDataFilepath);
        employeeDataList.forEach(System.out::println);

        //Build a Map<ManagerName, List<Employee>> using managerId and employee name.
        // lists employees under a specific manager by manger Name.
        Map<String, List<EmployeeData>>listEmployeesUnderManager =EmployeeService.listEmployeesUnderManager(employeeDataList);
        listEmployeesUnderManager.forEach((managerName,listOfEmployees)->
                System.out.println("Manager Name:"+managerName+", \n"+"List Of Employee Working Under above Manager:\n"+listOfEmployees)
        );

        //Find the average salary of each manager’s team.
        //System.out.println(EmployeeService.calculateAverageTeamSalaryPerManager(employeeDataList))
        ;


    }
}
