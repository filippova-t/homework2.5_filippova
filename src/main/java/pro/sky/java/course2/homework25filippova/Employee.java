package pro.sky.java.course2.homework25filippova;

public class Employee {
    private String firstName;
    private String lastName;


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode () {
        return java.util.Objects.hash(firstName, lastName);
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public String toString () {
        return "\"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\"";
    }
}
