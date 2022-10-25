package pro.sky.java.course2.homework25filippova;

import org.springframework.util.StringUtils;

public class Employee {
    private String firstName;
    private String lastName;
    private int departmentId;
    private int salary;


    public Employee(String firstName, String lastName, int departmentId, int salary) {
        this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public String getFullName () {
        return firstName + " " + lastName;}


    @Override
    public int hashCode() {
        return java.util.Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return getFirstName().equals(employee.getFirstName()) && getLastName().equals(employee.getLastName());
    }


    @Override
    public String toString() {
        return firstName + " " + lastName + " , отдел № " + departmentId + " , зарплата " + salary + " рублей";
    }


}
