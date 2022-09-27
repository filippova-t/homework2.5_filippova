package pro.sky.java.course2.homework25filippova;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.homework25filippova.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25filippova.exception.EmployeeNotFoundException;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public Employee addEmpl(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
       Employee employee = new Employee(firstName, lastName);
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/remove")
    public Employee removeEmpl (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.removeEmployee(employee);
    }

    @GetMapping("/find")
    public Employee findEmpl (@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeService.findEmployee(employee);
    }

    @GetMapping()
    public Collection<Employee> printListOfEmpl () {
        return employeeService.printListOfEmployees();
    }
}


