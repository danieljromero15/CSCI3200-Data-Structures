package CalculatorProject;

public class Main {
    public static void main(String[] args) {
        //String infix_string = "( 3 - 23 ) * 4 + 100 / 25 * 37";
        //String infix_string2 = "(3-23)*4+100/25*37";

        //String infix_string = "( 3 – 23 ) * 4 + 100";
        //String infix_string2 = "(3–23)*4+100";

        String infix_string = "137 - 47 / 3";
        String infix_string2 = "137-47/3";

        System.out.println(infix_string);
        String postfix_string = Calculator.infix_to_postfix(infix_string);
        System.out.println(postfix_string);

        System.out.println();

        System.out.println(infix_string2);
        String postfix_string2 = Calculator.infix_to_postfix(infix_string2);
        System.out.println(postfix_string2);

        //int result = Calculator.postfix_evaluation(postfix_string);
        //int result = Calculator.postfix_evaluation("3 23 - 4 * 100 25 / 37 * +");

        //System.out.println("The input expression value is " + result);

    }
}
