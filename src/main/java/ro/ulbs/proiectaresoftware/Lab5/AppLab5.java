package ro.ulbs.proiectaresoftware.Lab5;

public class AppLab5 {
    static void main() {
        //a)
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println(result);
        //b)
        AdvancedCalculator advancedCalculator = new AdvancedCalculator(10);
        int rezultAdvanced = advancedCalculator.power(3).divide(2).root(4).result();
        System.out.println(rezultAdvanced);
        //c)

    }
}
