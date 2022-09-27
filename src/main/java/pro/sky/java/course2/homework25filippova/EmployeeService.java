package pro.sky.java.course2.homework25filippova;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    Collection<Employee> printListOfEmployees();
}
