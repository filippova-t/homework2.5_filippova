package pro.sky.java.course2.homework25filippova.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalSymbol extends RuntimeException {
    public IllegalSymbol(String message) {
        super(message);
    }
}
