package pro.sky.java.course2.homework25filippova;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class NewEmployeeController {
    private final NewEmployeeService newEmployeeService;

    public NewEmployeeController(NewEmployeeService newEmployeeService) {
        this.newEmployeeService = newEmployeeService;
    }


    @GetMapping("max-salary")
    public Employee employeeWithMaximumSalary(@RequestParam ("departmentId") int departmentId) {
        return newEmployeeService.findEmployeeWithMaxSalaryInDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee employeeWithMinimumSalary(@RequestParam ("departmentId") int departmentId) {
        return newEmployeeService.findEmployeeWithMinSalaryInDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> employeesInDepartment (@RequestParam (value = "departmentId", required = false) int departmentId) {
    return newEmployeeService.printListOfEmployeesInDepartment(departmentId);


     }

   @GetMapping("/alls")
   public List<Employee> employees () {
        return newEmployeeService.printListOfEmployees();
   }
}



