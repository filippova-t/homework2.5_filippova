package pro.sky.java.course2.homework25filippova;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee findEmployeeWithMinSalaryInDepartment(int departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();

    }

    @Override
    public Employee findEmployeeWithMaxSalaryInDepartment(int departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();

    }


    @Override
    public List<Employee> printListOfEmployeesInDepartment(int departmentId) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());

    }


    @Override
    public Map<Integer, List<Employee>> printEmployeeGroupByDepartment() {
        Map<Integer, List<Employee>> listEmployees = new HashMap<>();
        List <Integer> departmentId = employeeService.getEmployees().values().stream()
                .map(Employee::getDepartmentId)
                .distinct()
                .collect(Collectors.toList());


       for (int i = 0; i < departmentId.size(); i++) {
           int finalI = i;
           List<Employee> listEmployeeInDepartment = employeeService.getEmployees().values().stream()
                            .filter(e -> e.getDepartmentId() == departmentId.get(finalI)).collect(Collectors.toList());
            listEmployees.put(departmentId.get(finalI), listEmployeeInDepartment);
        }

      return listEmployees;
    }
}