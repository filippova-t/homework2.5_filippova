package pro.sky.java.course2.homework25filippova.exception;

public class EmployeeAlreadyAddedException extends  RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
