package pro.sky.java.course2.homework25filippova;

import java.util.List;
import java.util.Map;

public interface NewEmployeeService {


    Employee findEmployeeWithMinSalaryInDepartment(int departmentId);

    Employee findEmployeeWithMaxSalaryInDepartment(int departmentId);

    List<Employee> printListOfEmployeesInDepartment(int departmentId);

    Map<Integer, List<Employee>> printEmployeeGroupByDepartment();
}
