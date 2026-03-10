package converter.list_to_map.service;

import converter.list_to_map.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapConverter {

    public static Map<Long,Employee>  converter(List<Employee> employees)
    {
        Map<Long, Employee> employeeMap =
                employees.stream().collect(Collectors.toMap(Employee::getEmployeeId, Function.identity(),(existing, replacement) -> replacement));

       return  employeeMap;
    }
}
