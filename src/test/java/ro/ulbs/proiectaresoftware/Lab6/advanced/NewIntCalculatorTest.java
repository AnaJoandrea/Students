package ro.ulbs.proiectaresoftware.Lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewIntCalculatorTest {

    private NewIntCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new NewIntCalculator();
        calculator.init(); // starea devine 0
    }

    @Test
    public void testAddPositive() {
        Integer a = 10;
        calculator.add(a);
        Assertions.assertEquals(10, calculator.result());
    }

    @Test
    public void testAddNegatives() {
        Integer a = -5;
        calculator.add(a);
        Assertions.assertEquals(-5, calculator.result());
    }

    @Test
    public void testSubtractPositives() {
        calculator.add(20);
        calculator.subtract(5);
        Assertions.assertEquals(15, calculator.result());
    }

    @Test
    public void testSubtractNegatives() {
        calculator.add(10);
        calculator.subtract(-5);
        Assertions.assertEquals(15, calculator.result());
    }

    @Test
    public void testMultiplyPositives() {
        calculator.add(5);
        calculator.multiply(4);
        Assertions.assertEquals(20, calculator.result());
    }

    @Test
    public void testMultiplyNegatives() {
        calculator.add(5);
        calculator.multiply(-4);
        Assertions.assertEquals(-20, calculator.result());
    }

    @Test
    public void testMultiplyBy0() {
        calculator.add(5);
        calculator.multiply(0);
        Assertions.assertEquals(0, calculator.result());
    }

    @Test
    public void testDividePositives() {
        calculator.add(20);
        calculator.divide(4);
        Assertions.assertEquals(5, calculator.result());
    }

    @Test
    public void testDivideNegatives() {
        calculator.add(20);
        calculator.divide(-4);
        Assertions.assertEquals(-5, calculator.result());
    }

    @Test
    public void testDivideBy0() {
        calculator.add(10);
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0);
        });
        Assertions.assertNotNull(exception);
    }
}