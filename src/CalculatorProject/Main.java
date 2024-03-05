package CalculatorProject;

public class Main {
    public static void main(String[] args) {
        //String infix_string = "( 3 - 23 ) * 4 + 100 / 25 * 37";
        //String infix_string2 = "(3-23)*4+100/25*37";

        //String infix_string = "( 3 – 23 ) * 4 + 100";
        //String infix_string2 = "(3–23)*4+100";

        //String infix_string = "137 - 47 / 3";
        //String infix_string2 = "137-47/3";

        print_infix_evaluation("(3–23)*4+100");

        print_infix_evaluation("( 3 - 23 ) * 4 + 100 / 25 * 37");

        print_infix_evaluation("137-47/3");

        print_infix_evaluation("((4+5) * (3-(8/4)))");

        print_infix_evaluation("((8-(5*2))+(4*6)");

        print_infix_evaluation("18 + 30 / (12 + 3) – 4");

        print_infix_evaluation("(20 – (1 + 6) * 2) / (1 + 2)");

        System.out.println("\nEvaluating Postfix:\n");

        print_postfix_evaluation("12 3 4 + * 2 / 5 –");

        print_postfix_evaluation("10 9 8 7 5 – / + *");

        print_postfix_evaluation("14 15 + 12 – 3 * 17 /");

    }

    public static void print_infix_evaluation(String infix){
        System.out.println("Infix: " + infix);
        String postfix_string = Calculator.infix_to_postfix(infix);
        print_postfix_evaluation(postfix_string);
    }

    public static void print_postfix_evaluation(String postfix){
        System.out.println("Postfix: " + postfix);
        double result = Calculator.postfix_evaluation(postfix);
        System.out.println("The input expression value is " + result + System.lineSeparator());
    }
}
