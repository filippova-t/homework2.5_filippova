package pro.sky.java.course2.homework25filippova;

import java.util.List;

public interface NewEmployeeService {


    Employee findEmployeeWithMinSalaryInDepartment(int departmentId);

    Employee findEmployeeWithMaxSalaryInDepartment(int departmentId);

    List<Employee> printListOfEmployeesInDepartment(int departmentId);

    List <Employee> printListOfEmployees();
}
