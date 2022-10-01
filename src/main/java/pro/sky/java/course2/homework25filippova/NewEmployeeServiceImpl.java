package pro.sky.java.course2.homework25filippova;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NewEmployeeServiceImpl implements NewEmployeeService {
    private EmployeeService employeeService;
    public NewEmployeeServiceImpl(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findEmployeeWithMinSalaryInDepartment(int departmentId) {
        Employee employeeWithMinimalSalary =
               employeeService.getEmployees().values().stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .min(Comparator.comparingInt(employee -> employee.getSalary()))
                        .get();
        return employeeWithMinimalSalary;

    }

    @Override
    public Employee findEmployeeWithMaxSalaryInDepartment(int departmentId) {
        Employee employeeWithMaximalSalary =
                employeeService.getEmployees().values().stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .max(Comparator.comparingInt(employee -> employee.getSalary()))
                        .get();
        return employeeWithMaximalSalary;

    }


    @Override
    public List <Employee> printListOfEmployeesInDepartment(int departmentId) {
        return employeeService.getEmployees().values().stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .collect(Collectors.toList());

    }

    @Override
    public List <Employee> printListOfEmployees() {
        return employeeService.getEmployees().values().stream().
                sorted (Comparator.comparingInt(Employee :: getDepartmentId))
                .collect(Collectors.toList());

    }

}
