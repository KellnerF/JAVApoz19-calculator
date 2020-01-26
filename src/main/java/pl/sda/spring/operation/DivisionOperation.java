package pl.sda.spring.operation;

import org.springframework.stereotype.Component;
import pl.sda.spring.exception.DivisionByZeroException;

@Component
class DivisionOperation implements Operation {


    @Override
    public double calculate(double arg1, double arg2) throws DivisionByZeroException{
        if (arg2 !=0){
            return arg1/arg2;
        }else
           throw new DivisionByZeroException ("Nie dziel przez zero");

    }

    @Override
    public OperationType getSupportedOperationType() {
        return OperationType.DIVISION;
    }
}
