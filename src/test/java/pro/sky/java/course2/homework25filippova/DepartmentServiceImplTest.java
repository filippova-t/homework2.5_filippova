package pro.sky.java.course2.homework25filippova;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeServiceImpl;

    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;

    @BeforeEach
    public void createListOfEmployees() {
        Map<String, Employee> listOfEmployees = new HashMap<>(Map.of(
                "Иван Иванов", new Employee("Иван", "Иванов", 1, 50000),
                "Петр Петров", new Employee("Петр", "Петров", 1, 60000),
                "Семен Семенов", new Employee("Семен", "Семенов", 2, 70000),
                "Александр Александров", new Employee("Александр", "Александров", 2, 80000),
                "Илья Ильин", new Employee("Илья", "Ильин", 3, 45000),
                "Денис Денисов", new Employee("Денис", "Денисов", 3, 90000)));
        Mockito.when(employeeServiceImpl.getEmployees()).thenReturn(listOfEmployees);
    }


    @ParameterizedTest
    @MethodSource("paramsDepartmentId")
    void findEmployeeWithMinSalaryInDepartment(int departmentId) {
        Assertions.assertThat(departmentServiceImpl.findEmployeeWithMinSalaryInDepartment(departmentId))
                .isEqualTo(employeeServiceImpl.getEmployees().values().stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .min(Comparator.comparingInt(employee -> employee.getSalary())).get());
    }


    @ParameterizedTest
    @MethodSource("paramsDepartmentId")
    void findEmployeeWithMaxSalaryInDepartment(int departmentId) {
        Assertions.assertThat(departmentServiceImpl.findEmployeeWithMaxSalaryInDepartment(departmentId))
                .isEqualTo(employeeServiceImpl.getEmployees().values().stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .max(Comparator.comparingInt(employee -> employee.getSalary())).get());
    }

    @ParameterizedTest
    @MethodSource("paramsDepartmentId")
    void printListOfEmployeesInDepartment(int departmentId) {
        Assertions.assertThat(departmentServiceImpl.printListOfEmployeesInDepartment(departmentId))
                .isEqualTo(employeeServiceImpl.getEmployees().values().stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .collect(Collectors.toList()));
    }

  @Test
    void printEmployeeGroupByDepartment() {
      Map<Integer, List<Employee>> listEmployees = new HashMap<>();
      List <Integer> departmentId = employeeServiceImpl.getEmployees().values().stream()
              .map(Employee::getDepartmentId)
              .distinct()
              .collect(Collectors.toList());


      for (int i = 0; i < departmentId.size(); i++) {
          int finalI = i;
          List<Employee> listEmployeeInDepartment = employeeServiceImpl.getEmployees().values().stream()
                  .filter(e -> e.getDepartmentId() == departmentId.get(finalI)).collect(Collectors.toList());
          listEmployees.put(departmentId.get(finalI), listEmployeeInDepartment);
      }
        Assertions.assertThat(departmentServiceImpl.printEmployeeGroupByDepartment())
                .isEqualTo(listEmployees);

    }



    public static Stream<Arguments> paramsDepartmentId() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3)
        );
    }
}
