package collections_and_streams.method_reference;

import java.util.Arrays;
import java.util.List;

public class MethodRefEx
{
    public static void main(String[] args) {
        List<String> names= Arrays.asList("allen","smith","Scott","Pitter");

        List<String> uNames = names.stream().map(String::toUpperCase).toList();
        System.out.println(uNames);
    }
}
