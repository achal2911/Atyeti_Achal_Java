package collections_and_streams.method_reference.employeestream;

public class EmployeeDTO {
    private int id;
    private String name;
    private String department;

    public EmployeeDTO(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTOCreator creator = EmployeeDTO::new;
        return creator.create(employee.getId(), employee.getName(), employee.getDepartment());
    }

    @FunctionalInterface
    interface EmployeeDTOCreator {
        EmployeeDTO create(int id, String name, String department);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}
