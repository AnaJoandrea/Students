package ro.ulbs.proiectaresoftware.Lab5.advanced;

public class NewIntCalculator extends ACalculator {

    public NewIntCalculator(int initialValue) {
        this.state = initialValue;
    }

    @Override
    protected void init() {
        this.state = 0;
    }
    public NewIntCalculator add(int value) {
        this.state = (Integer) this.state + value;
        return this;
    }
    public NewIntCalculator subtract(int value) {
        this.state = (Integer) this.state - value;
        return this;
    }
    public NewIntCalculator multiply(int value) {
        this.state = (Integer) this.state * value;
        return this;
    }
}