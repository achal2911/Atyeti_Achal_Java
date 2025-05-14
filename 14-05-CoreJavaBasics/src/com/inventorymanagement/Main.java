package com.inventorymanagement;

import com.inventorymanagement.inventory.Billing;
import com.inventorymanagement.inventory.Customer;
import com.inventorymanagement.producttypes.ClothingProducts;
import com.inventorymanagement.producttypes.ElectronicProducts;
import com.inventorymanagement.util.Product;

public class Main
{
    public static void main(String[] args) {

        //"Calling Customer class Constructor";
        Customer customer1=new Customer("Achal",111,7777899900L,"achal@gmail.com");

         //Product is my Abstract class  Product is a super class for Electronic so ,I created Electronic class Object With Product reference
        //Now we are calling Electronic class constructor with Has-A relation I am providing Customer object reference to the Electronic constructor
        Product laptop=new ElectronicProducts("laptop",2,40000.0,customer1);


    //now I am printing Electronic class reference so it will call to String Overridden method from Electronic class
        System.out.println(laptop);


      //Creating Object for Billing class
        Billing bill=new Billing();

        double billForElectronicProduct= bill.generateBill(laptop);
        System.out.println("Original Price "+laptop.getPrice()*laptop.getProductQuantity());
        System.out.println("Total bill After Adding discount : "+billForElectronicProduct);

        System.out.println("..........................................................");

       // Customer customer2=new Customer("Isa",201,376351037L);
        Product tShirt=new ClothingProducts("T-shirt",1,500.0,customer1);
        System.out.println(tShirt);


        //if we want to add the product
       tShirt.updateStockQuantity(-3);
       System.out.println(tShirt);


        double billForClothingProduct= bill.generateBill(tShirt);
        System.out.println("Original Price "+tShirt.getPrice()*tShirt.getProductQuantity());
        System.out.println("Total bill After Adding discount : "+billForClothingProduct);






    }
}
