package pl.sda.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.spring.exception.DivisionByZeroException;
import pl.sda.spring.operation.OperationType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void shouldReturnFiveForGivenArgumentsOnAdditionOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 3.0;

        //when
        double actual = calculator.calculate(OperationType.ADDITION, arg1, arg2);

        //then
        Assert.assertEquals(5.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnOneForGivenArgumentsOnSubtractionOperation () {
        //given
        double arg1 = 3.0;
        double arg2 = 2.0;

        //when
        double actual = calculator.calculate(OperationType.SUBTRACTION, arg1,arg2);

        //then
        Assert.assertEquals(1,actual,0.00000001);
    }

    @Test
    public void shouldReturnTwentyFourForGivenArgumentsOnMultiplicationOperation () {
        double arg1 = 4.0;
        double arg2 = 6.0;

        double actual = calculator.calculate(OperationType.MULTIPLICATION, arg1,arg2);

        Assert.assertEquals(24 , actual, 0.0000001 );

    }

    @Test
    public void shouldReturnFiveForGivenArgumentsOnDivisionOperation () {

        double arg1 = 10 ;
        double arg2 = 2;

        double actual = calculator.calculate(OperationType.DIVISION, arg1,arg2);

        Assert.assertEquals(5,actual, 0.000001);
    }

    @Test (expected = DivisionByZeroException.class)
    public void shouldReturnExeptionForGivenArgumentsOnDivisionOperation () {
        double arg1 = 10 ;
        double arg2 = 0;
        double actual = calculator.calculate(OperationType.DIVISION, arg1,arg2);

    }

    @Test
    public void shouldReturnPercentForGivenArgumentsOnPercentOperation () {
        double arg1 = 10 ;
        double arg2 = 50 ;

        double actual = calculator.calculate(OperationType.PERCENTAGE,arg1,arg2);

        Assert.assertEquals(5,actual, 0.000001);

    }

    @Test
    public void shouldReturnFourForGivenArgumentsOnPowerOperation (){
        double arg1 = 2;
        double arg2 = 3;

        double actual  = calculator.calculate(OperationType.POWER,arg1,arg2);

        Assert.assertEquals(8,actual,0.0000001);
    }

}
