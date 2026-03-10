package collections_and_streams.method_reference.employeestream;

import java.util.Arrays;
import java.util.List;

public class EmployeeProcessor {
    public static boolean isEligible(Employee employee) {
        return employee.getSalary() > 50000 && "IT".equalsIgnoreCase(employee.getDepartment());
    }

    public static int compareByName(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }

    public void printDto(EmployeeDTO dto) {
        System.out.println(dto);
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Sakshi", 55000, "IT"),
                new Employee(2, "Mayur", 45000, "Sales"),
                new Employee(3, "Neha", 67000, "HR"),
                new Employee(4, "Pranav", 70000, "IT"),
                new Employee(5, "Akash", 30000, "IT"),
                new Employee(6, "Ankita", 65000, "Finance"),
                new Employee(7, "Yash", 91000, "IT")
        );

        EmployeeProcessor processor = new EmployeeProcessor();

        employees.stream().sorted(EmployeeProcessor::compareByName)
                .filter(EmployeeProcessor::isEligible).map(EmployeeDTO::toDTO).forEach(processor::printDto);

    }
}
