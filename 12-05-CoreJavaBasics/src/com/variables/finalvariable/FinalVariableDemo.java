package com.variables.finalvariable;


class Student
{
    //Final static variable:common for all students
    public static final String COLLEGE_NAME="Government College of Engineering,Chandrapur";

    //Final Instance Variable:unique to each student
    private final int rollNumber;

    private String name;

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public  void printStudentDetails()
    {
        // final local variable
        final String message = "Student Details:";
        System.out.println(message);

        System.out.println("Student Name:"+name);
        System.out.println("Student Roll Number:"+rollNumber);
        System.out.println("College Name:"+COLLEGE_NAME);

        //below line will give compile time error because  we cannot reinitialize  final variable
       // message="new message";
    }
}
public class FinalVariableDemo
{
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(102, "Bob");

        s1.printStudentDetails();
        System.out.println();
        s2.printStudentDetails();

        //below lines will cause compile-time errors:
        // s1.rollNumber = 200; //Cannot assign a value to final variable
        // Student.COLLEGE_NAME = "Another College"; // Cannot assign to final static
    }

}
