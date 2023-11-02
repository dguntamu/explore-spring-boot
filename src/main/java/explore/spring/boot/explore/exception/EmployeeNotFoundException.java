package explore.spring.boot.explore.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeNotFoundException extends RuntimeException{
    private String errorMessage;
    public EmployeeNotFoundException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }
}
