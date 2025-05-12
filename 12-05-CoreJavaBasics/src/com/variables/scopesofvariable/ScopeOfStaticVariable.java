package com.variables.scopesofvariable;

/*Static Variables are the variables which once declared can be used
 anywhere even outside the class without initializing the class.*/

/*if we want to use static variable in same class then we call it directly,but if
we want use it in another class then we can call it by using className.*/

class Demo
{
    static  int var=10;
}
public class ScopeOfStaticVariable {
    public static void main(String[] args) {
        System.out.println("value:"+Demo.var);
    }
}
