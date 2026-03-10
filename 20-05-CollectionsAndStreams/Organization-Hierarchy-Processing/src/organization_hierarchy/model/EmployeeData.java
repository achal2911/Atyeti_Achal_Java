package organization_hierarchy.model;

public class EmployeeData {
    private String employeeId;
    private String employeeName;
    private String managerId;
    private String department;
    private double salary;

    public EmployeeData(String employeeId, String employeeName, String managerId, String department, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.managerId = managerId;
        this.department = department;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return
                "employeeId='" + employeeId +
                ", employeeName='" + employeeName +
                ", managerId='" + managerId +
                ", department='" + department +
                ", salary=" + salary ;
    }

}
