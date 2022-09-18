package pro.sky.java.course2.homework25filippova;

public interface EmployeeService {

    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    String printListOfEmployees();
}
