package collections_and_streams.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstructorRefEx {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("allen","smith","Scott","Pitter");

        List<Student>students=new ArrayList<>();
//
//        System.out.println("With for each loop:");
//        for(String name:names)
//        {
//            students.add(new Student(name));
//        }
//
//        System.out.println("using streams:");
//        students= names.stream().map(name -> new Student(name)).toList();
//        System.out.println(students);

        // Constructor method reference
        System.out.println("with constructor reference:");
        students=names.stream().map(Student::new).toList();
        System.out.println(students);



    }
}
