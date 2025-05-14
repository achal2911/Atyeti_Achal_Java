package com.inventorymanagement.inventory;


import com.inventorymanagement.util.Product;

public class Billing
{
    //has a relation by passing Product
    public double generateBill(Product product)
    {
        System.out.println("Generating Bill for "+product.getProductName());
       double total=product.getPrice()*product.getProductQuantity();
       double discount=product.calculateDiscount();
       total-=discount;
       return  total;

    }
}
