package com.variables.scopesofvariable;

public class ScopeOfLocalVariable {

    String str="hello";

    public void scope()
    {

        String str1="world";
        System.out.println(str1);
    }

    public static void main(String[] args) {

        //below line will generate error because the scope of local variable is only up to the method or block
       // System.out.println(str1);
        // Local variables don’t exist after method’s execution is over.
    }
}
