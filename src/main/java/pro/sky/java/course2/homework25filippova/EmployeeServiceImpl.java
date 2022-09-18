package pro.sky.java.course2.homework25filippova;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework25filippova.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25filippova.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;
@Service

public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employees = new ArrayList<> (List.of(
            new Employee("Иван","Иванов"),
            new Employee("Петр","Петров"),
            new Employee("Семен","Семенов"),
            new Employee("Александр","Александров"),
            new Employee("Илья","Ильин"),
            new Employee("Денис","Денисов"),
            new Employee("Светлана","Сорокина"),
            new Employee("Ксения","Кукушкина"),
            new Employee("Ольга","Лебедева"),
            new Employee("Ирина","Журавлева")

    ));
    @Override
    public void addEmployee(Employee employee) {
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже есть в списке");
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (!employees.contains(employee) || employee == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(employee);

    }

    @Override
    public Employee findEmployee(Employee employee) {
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }
    @Override
    public String printListOfEmployees () {
        return employees.toString();
    }

}
