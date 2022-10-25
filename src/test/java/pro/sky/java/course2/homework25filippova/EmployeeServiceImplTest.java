package pro.sky.java.course2.homework25filippova;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.homework25filippova.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.homework25filippova.exception.EmployeeNotFoundException;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
    private final Employee expected = new Employee("Ivanov", "Ivan", 1, 50000);



    @Test
    void addEmployee() {

        Employee actual = employeeServiceImpl.addEmployee(expected);
        if (employeeServiceImpl.getEmployees().containsKey(expected.getFullName())) {
            assertThatExceptionOfType(EmployeeAlreadyAddedException.class)
                    .isThrownBy(() -> employeeServiceImpl.addEmployee(expected))
                    .withMessage("Данный сотрудник уже есть в списке");
        } else{
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    void removeEmployee() {
        Employee actual = employeeServiceImpl.addEmployee(expected);
        employeeServiceImpl.removeEmployee(expected);
        if (!employeeServiceImpl.getEmployees().containsKey(expected.getFullName())) {
            assertThatExceptionOfType(EmployeeNotFoundException.class)
                    .isThrownBy(() -> employeeServiceImpl.removeEmployee(expected))
                    .withMessage("Сотрудник не найден");
        } else {
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Test
    void findEmployee() {
        Employee actual = employeeServiceImpl.addEmployee(expected);
        employeeServiceImpl.findEmployee(expected);
        if (!employeeServiceImpl.getEmployees().containsKey(expected.getFullName())) {
            assertThatExceptionOfType(EmployeeNotFoundException.class)
                    .isThrownBy(() -> employeeServiceImpl.findEmployee(expected))
                    .withMessage("Сотрудник не найден");
        } else {
            assertThat(actual).isEqualTo(expected);
        }
    }


}