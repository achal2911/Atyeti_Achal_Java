package employeedata_analytics_withstreams.util;

import employeedata_analytics_withstreams.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeUtility {


    public Map<String, Long> getGenderCount(List<Employee> employees) {
        Map<String, Long> genderCount = employees.stream().collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
        return genderCount;

    }

    public Set<String> getAllDepartments(List<Employee> employees) {
        Set<String> departments = employees.stream().map(Employee::department).collect(Collectors.toSet());
        return departments;
    }

    public Map<String, Double> getAverageAgeByGender(List<Employee> employees) {
        Map<String, Double> average = employees.stream().collect(Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age)));

        return average;
    }

    public Employee getHighestPaidEmployee(List<Employee> employees) {
        Optional<Employee> highestPaidEmployee = employees.stream().max(Comparator.comparingDouble(Employee::salary));
        return highestPaidEmployee.get();
    }

    public void getEmployeesJoinedAfter2015(List<Employee> employees) {
        employees.stream().filter(x -> x.yearOfJoining() > 2015).map(Employee::name).forEach(System.out::println);
    }

    public Map<String, Long> getEmployeeCountByDepartment(List<Employee> employees) {
        Map<String, Long> empCount = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        return empCount;
    }

    public Map<String, Double> getAverageSalaryByDepartment(List<Employee> employees) {
        Map<String, Double> avgSalByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
        return avgSalByDepartment;
    }

    public Employee getYoungestMaleInDevelopment(List<Employee> employees) {
        Optional<Employee> youngestMaleEmployee = employees.stream().filter(x -> (x.gender().equalsIgnoreCase("male") && x.department().equalsIgnoreCase("development"))).min(Comparator.comparing(Employee::age));
        return youngestMaleEmployee.get();
    }

    public Optional<Employee> getMostExperiencedEmployee(List<Employee> employees) {
        return employees.stream().min(Comparator.comparing(Employee::yearOfJoining));
    }


    public Map<String, Long> getGenderCountInSales(List<Employee> employees) {
        Map<String, Long> salesGenderCount = employees.stream().filter(x -> x.department().equalsIgnoreCase("sales"))
                .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));

        return salesGenderCount;
    }

    public static Map<String, Double> getAverageAndTotalSalary(List<Employee> employees) {
        Map<String, Double> result = employees.stream()
                .collect(Collectors.teeing(
                        Collectors.summingDouble(Employee::salary),  // collector1: total salary
                        Collectors.averagingDouble(Employee::salary), // collector2: average salary
                        (total, average) -> {
                            Map<String, Double> map = new HashMap<>();
                            map.put("TotalSalary", total);
                            map.put("AverageSalary", average);
                            return map;
                        }
                ));

        return result;
    }

    public void partitionByAge25(List<Employee> employees) {
        Map<Boolean, List<Employee>> emp = employees.stream().collect(Collectors.partitioningBy(x -> x.age() <= 25));
        List<Employee> empHavingAgeLessOrEqual25 = emp.get(true);
        List<Employee> empHavingAgeMoreThan25 = emp.get(false);

        System.out.println("Partition by age: ≤25 and >25");
        System.out.println(empHavingAgeLessOrEqual25);
        System.out.println(empHavingAgeMoreThan25);
    }


    public Optional<Employee> getOldestEmployee(List<Employee> employees) {
        Optional<Employee> oldestEmployee = employees.stream().max(Comparator.comparing(Employee::age));
        return oldestEmployee;
    }

}
