package com.inventorymanagement.inventory;

public class Customer
{
    private  String customerName;
    private int customerId;
    private long customerMobileNo;
    private String customerEmailId;

    public Customer(String customerName, int customerId, long customerMobileNo, String customerEmailId) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.customerMobileNo = customerMobileNo;
        this.customerEmailId = customerEmailId;
    }
    //constructor overloading
    public Customer(String customerName, int customerId, long customerMobileNo) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.customerMobileNo = customerMobileNo;

    }

    //encapsulation setter and getter
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getCustomerMobileNo() {
        return customerMobileNo;
    }

    public void setCustomerMobileNo(long customerMobileNo) {
        this.customerMobileNo = customerMobileNo;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    @Override
    public String toString() {
        return
                "\ncustomerName='" + customerName + '\'' +
                ", customerId=" + customerId +
                ", customerMobileNo=" + customerMobileNo +
                ", customerEmailId='" + customerEmailId ;
    }
}
