package CalculatorProject;

public class Main {
    public static void main(String[] args) {
        //Calculator calc = new Calculator();
        String result = Calculator.infix_to_postfix("( 3 – 23 ) * 4 + 100"); // 3 23 - 4 * 100 +

        System.out.println(result);

        int coolResult = Calculator.postfix_evaluation("3 23 - 4 * 100 +"); // 20

        System.out.println(coolResult);
    }
}
