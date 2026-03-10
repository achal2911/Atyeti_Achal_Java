package com.inventorymanagement.producttypes;


import com.inventorymanagement.inventory.Customer;
import com.inventorymanagement.util.Product;
import com.inventorymanagement.util.Returanble;

//Here i Applied multiple inheritance
public class ElectronicProducts extends Product implements Returanble
{


    public ElectronicProducts(String productName, int productQuantity, double price, Customer customer) {
        super(productName, productQuantity, price, customer);
    }
//method overriding from parent class Product
    @Override
    public double calculateDiscount()
    {
        if(getPrice()>2000) {
            System.out.println(" as price of product is >2000 so..we have 10%discount on electronic product");
            return getPrice() * 0.1;//10%discount on electronic product
        }
        else{
            return getPrice();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    //method overridden from Returnable Interface
    @Override
    public boolean canBeReturned() {
        return true;            // Electronic device can be returned
    }
}
