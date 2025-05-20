package organization_hierarchy.service;

import organization_hierarchy.model.EmployeeData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    public static Map<String, List<EmployeeData>> listEmployeesUnderManager(List<EmployeeData> employeeDataList)
    {
        // 1: Map employeeId to employeeName
        Map<String, String> idToNameMap = employeeDataList.stream()
                .collect(Collectors.toMap(EmployeeData::getEmployeeId, EmployeeData::getEmployeeName));

        // Group employees by manager name
        Map<String, List<EmployeeData>> listOfEmployeesWorkingUnderEachManager = employeeDataList.stream().filter(x->x.getManagerId()!=null).
                collect(Collectors.groupingBy(e->idToNameMap.get(e.getManagerId())));

        return listOfEmployeesWorkingUnderEachManager;
    }

//    public static double calculateAverageTeamSalaryPerManager(List<EmployeeData> employeeDataList)
//    {
//        Map<String, List<EmployeeData>> listEmployeesUnderManager= listEmployeesUnderManager(employeeDataList);
//
//        double d=0.0;
//        for (Map<String, List<EmployeeData>> map:listEmployeesUnderManager.entrySet())
//        {
//            d=map.stream().map(EmployeeData::getSalary).collect(Collectors.averagingDouble(x -> x.doubleValue()));
//        }
//        return d;
//
//    }


//    public static Map<String, Double> topThreeDepartmentSalary(List<EmployeeData> employees) {
//
//        return employees.stream()
//                .filter(x -> x.getManagerId() != null)
//                .collect(Collectors.groupingBy(
//                        x -> x.getDepartment(),
//                        Collectors.summingDouble(Employee::getSalary)
//                )).entrySet().stream()
//                .sorted((x, y) -> (int) (y.getValue() - x.getValue()))
//                .limit(3)
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue
//                ));
//    }

//dgd

}
