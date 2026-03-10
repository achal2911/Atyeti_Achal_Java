package com.examples.suppressed_exceptions_try_with_resource;

class MyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        throw  new RuntimeException("Closing Resource failed!!");
    }
}
public class Test1 {
    public static void main(String[] args) {
        try(MyResource myResource=new MyResource())
        {
            throw  new RuntimeException("Exception in try");
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
//here Exceptions from close() are attached to the main one using addSuppressed()
//Exceptions in close()
// are not lost—they are attached as suppressed exceptions to the main one.