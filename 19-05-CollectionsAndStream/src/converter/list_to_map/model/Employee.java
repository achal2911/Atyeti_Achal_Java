package converter.list_to_map.model;

public class Employee {

    private long employeeId;
    private String employeeName;
    private  String employeeDesignation;
    private String employeeDepartment;
    private long phoneNumber;


    public Employee(long employeeId, String employeeName, String employeeDesignation, String employeeDepartment, long phoneNumber) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
        this.employeeDepartment = employeeDepartment;
        this.phoneNumber = phoneNumber;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName +
                ", employeeDesignation='" + employeeDesignation +
                ", employeeDepartment='" + employeeDepartment +
                ", phoneNumber=" + phoneNumber;
    }
}
