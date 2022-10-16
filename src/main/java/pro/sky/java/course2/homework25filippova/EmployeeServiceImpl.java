package pro.sky.java.course2.homework25filippova;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework25filippova.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25filippova.exception.EmployeeNotFoundException;
import pro.sky.java.course2.homework25filippova.exception.IllegalSymbol;

import java.util.*;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> employees;
    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже есть в списке");
        }
        else if (!StringUtils.isAlpha(employee.getFirstName()) || (!StringUtils.isAlpha(employee.getLastName()))) {
            throw new IllegalSymbol("Имя или фамилия содержат недопустимые символы");
        }
        else if (!StringUtils.equals(employee.getFirstName(), StringUtils.capitalize(employee.getFirstName())) ||
                !StringUtils.equals(employee.getLastName(), StringUtils.capitalize(employee.getLastName()))) {
            throw new IllegalSymbol("Имя или фамилия начинаются не с заглавной буквы");
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

    @Override
    public int calculateSumOfSalaryPerMonth() {
        int sum;
        List<Integer> salaries =
        employees.values().stream()
                .map(e -> e.getSalary())
                .collect(Collectors.toList());
        sum = salaries.stream().mapToInt(e -> (int)e)
                .sum();
        return sum;
    }

    @Override
    public Employee findEmployeeWithMinimumSalary() {
        return employees.values().stream()
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();

    }


    @Override
    public Employee findEmployeeWithMaximumSalary() {
        return employees.values().stream()
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .get();
    }



    }
