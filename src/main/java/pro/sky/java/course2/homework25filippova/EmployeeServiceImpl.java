package pro.sky.java.course2.homework25filippova;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework25filippova.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25filippova.exception.EmployeeNotFoundException;

import java.util.*;

@Service

public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> employees;
    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }



    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже есть в списке");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(employee.getFullName());

    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }
    @Override
    public Collection<Employee> printListOfEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
