package com.variables.variablelifecycle;

public class Config {

    final static int MAX_STEPS = 10;
    final static int DEFAULT_TIMEOUT = 1000;

    // initializing static final variable using method
    final static String CURRENT_THREAD = getCurrentThread();

    //final static int LOGGED_TIMEOUT;
    //above line will give us error because final static variable must be initialized

    //static int LOGGED_TIMEOUT;
    //Initialization of a static variable is not mandatory,it will take the default values of variables according to their datatypes

    static {
        System.out.println("Max Steps: " + MAX_STEPS);
        System.out.println("Default time out: " + DEFAULT_TIMEOUT);
        System.out.println("Current Running Thread:" + CURRENT_THREAD);
    }

    public static String getCurrentThread() {
        return Thread.currentThread().getName();
    }


}
