package pl.sda.spring.operation;

import org.springframework.stereotype.Component;
import pl.sda.spring.exception.DivisionByZeroException;

@Component
class DivisionOperation implements Operation {

    private final String exceptionMessage;

    DivisionOperation(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }


    @Override
    public double calculate(double arg1, double arg2) throws DivisionByZeroException{
        if (arg2 !=0){
            return arg1/arg2;
        }else
           throw new DivisionByZeroException (exceptionMessage);

    }

    @Override
    public OperationType getSupportedOperationType() {
        return OperationType.DIVISION;
    }
}
