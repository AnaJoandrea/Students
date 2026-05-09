package ro.ulbs.proiectaresoftware.Lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {

    private DoubleCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new DoubleCalculator();
        calculator.init(); // starea devine 0.0
    }

    @Test
    public void testAddPositive() {
        calculator.add(10.5);
        Assertions.assertEquals(10.5, calculator.result());
    }

    @Test
    public void testAddNegatives() {
        calculator.add(-5.5);
        Assertions.assertEquals(-5.5, calculator.result());
    }

    @Test
    public void testSubtractPositives() {
        calculator.add(20.5);
        calculator.subtract(5.0);
        Assertions.assertEquals(15.5, calculator.result());
    }

    @Test
    public void testSubtractNegatives() {
        calculator.add(10.0);
        calculator.subtract(-5.5);
        Assertions.assertEquals(15.5, calculator.result());
    }

    @Test
    public void testMultiplyPositives() {
        calculator.add(5.0);
        calculator.multiply(4.0);
        Assertions.assertEquals(20.0, calculator.result());
    }

    @Test
    public void testMultiplyNegatives() {
        calculator.add(5.0);
        calculator.multiply(-4.0);
        Assertions.assertEquals(-20.0, calculator.result());
    }

    @Test
    public void testMultiplyBy0() {
        calculator.add(5.0);
        calculator.multiply(0.0);
        Assertions.assertEquals(0.0, calculator.result());
    }

    @Test
    public void testDividePositives() {
        calculator.add(20.0);
        calculator.divide(4.0);
        Assertions.assertEquals(5.0, calculator.result());
    }

    @Test
    public void testDivideNegatives() {
        calculator.add(20.0);
        calculator.divide(-4.0);
        Assertions.assertEquals(-5.0, calculator.result());
    }

    @Test
    public void testDivideBy0() {
        calculator.add(10.0);
        calculator.divide(0.0);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, calculator.result());
    }
}