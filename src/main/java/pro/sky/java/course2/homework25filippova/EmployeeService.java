package pro.sky.java.course2.homework25filippova;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    Map<String, Employee> getEmployees();

    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    Collection<Employee> printListOfEmployees();

    int calculateSumOfSalaryPerMonth();

    Employee findEmployeeWithMinimumSalary();

    Employee findEmployeeWithMaximumSalary();


}
