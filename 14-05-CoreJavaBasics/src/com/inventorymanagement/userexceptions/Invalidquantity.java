package com.inventorymanagement.userexceptions;

public class Invalidquantity extends RuntimeException
{

    public Invalidquantity() {
    }

    public Invalidquantity(String msg) {
        super(msg);
    }
}
