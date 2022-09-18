package pro.sky.java.course2.homework25filippova;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework25filippova.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25filippova.exception.EmployeeNotFoundException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public String addEmpl(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.addEmployee(employee);
        } catch (EmployeeAlreadyAddedException e) {
            return "Сотрудник уже есть в списке";
        }
        return employee.toString();
    }

    @GetMapping("/remove")
    public String removeEmpl (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.removeEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник отсутствует в списке";
        }
        return employee.toString();
    }

    @GetMapping("/find")
    public String findEmpl (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.findEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник отсутствует в списке";
        }
        return employee.toString();
    }

    @GetMapping("/list")
    public String printListOfEmpl () {
        return employeeService.printListOfEmployees();
    }
}


