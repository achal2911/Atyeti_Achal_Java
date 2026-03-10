package com.inventorymanagement.util;


import com.inventorymanagement.inventory.Customer;
import com.inventorymanagement.userexceptions.Invalidquantity;

public abstract class Product
{
    private String productName;
    private int productQuantity;
    private  double price;
    Customer customer;//has a relation

    public Product(String productName, int productQuantity, double price, Customer customer) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.price = price;
        this.customer=customer;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //concrete method
    public  void updateStockQuantity(int quantity)
    {
        try {
            if (quantity < 0) {
                throw new Invalidquantity("Quantity can't be -ve ,plz enter +ve value!!");

            } else {
                productQuantity += quantity;
            }
        }
        catch (Invalidquantity e ){
            System.err.println(e.getMessage());
    }
    }


    //abstract method
    public abstract double calculateDiscount();


    @Override
    public String toString() {
        return
                "customer details: " + customer +"\n"+"product details:"+
                "\nproductName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", price=" + price;
    }
}
