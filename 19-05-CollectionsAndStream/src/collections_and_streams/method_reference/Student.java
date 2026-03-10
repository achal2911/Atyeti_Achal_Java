package collections_and_streams.method_reference;

public class Student {
    private String name;


    public Student() {

    }

    public Student(String name) {
        this.name = name;

    }

    public String toString()
    {
        return "name:-"+name;
    }
}
