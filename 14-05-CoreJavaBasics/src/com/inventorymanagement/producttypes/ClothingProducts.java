package com.inventorymanagement.producttypes;


import com.inventorymanagement.inventory.Customer;
import com.inventorymanagement.util.Product;

public class ClothingProducts extends Product
{


    public ClothingProducts(String productName, int productQuantity, double price, Customer customer) {
        super(productName, productQuantity, price, customer);
    }

    @Override
    public double calculateDiscount()
    {

        if(getPrice()>1000) {
            System.out.println(" as amount is >1000 we have 5% discount on clothing product");
            return getPrice() * 0.05;
        }
        else
        {
            return getPrice();

        }
            //15%discount on clothing product
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
