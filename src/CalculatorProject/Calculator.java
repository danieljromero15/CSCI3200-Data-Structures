package CalculatorProject;
// Infix to postfix by Daniel
// Postfix eval by Aiden

import java.util.Stack;

public class Calculator {

    static boolean isNumber(char in) {
        return (int) in >= 48 && (int) in <= 57;
    }

    static boolean isLetter(char in) {
        return ((int) in >= 65 && (int) in <= 90) || ((int) in >= 97 && (int) in <= 122);
    }

    static boolean isBinOperator(char in) {
        return (int) in == 42 || (int) in == 43 || (int) in == 45 || (int) in == 47 || (int) in == 94 || (int) in == 8211 || (int) in == 8212;
    }

    static boolean isOpenPar(char in) {
        return (int) in == 40;
    }

    static boolean isClosePar(char in) {
        return (int) in == 41;
    }

    static int calcPrecedence(char in) {
        return switch ((int) in) {
            case 40, 41, 123, 125, 91, 93 -> // ( ) { } [ ]
                    4;
            case 94 -> // ^
                    3;
            case 42, 47 -> // * /
                    2;
            case 43, 45 -> // + -
                    1;
            default -> -1;
        };
    }

    static String infix_to_postfix(String infix) {
        StringBuilder out = new StringBuilder();
        Stack<String> postfixStack = new Stack<>();
        StringBuilder infix_no_spaces = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) { // adds all chars that aren't spaces to the character array
            if ((int) infix.charAt(i) == 8211 || (int) infix.charAt(i) == 8212) {
                infix_no_spaces.append('-'); // makes en and em dashes hyphens
            } else if (!isSpace(infix.charAt(i))) {
                infix_no_spaces.append(infix.charAt(i));
            }
        }

        char[] infixCharArray = infix_no_spaces.toString().toCharArray();

        for (int i = 0; i < infixCharArray.length; i++) {
            if (isNumber(infixCharArray[i])) {
                //System.out.println("isnum: " + infixCharArray[i]);

                StringBuilder tempNum = new StringBuilder(String.valueOf(infixCharArray[i]));
                while (i + 1 < infixCharArray.length && isNumber(infixCharArray[i + 1])) {
                    tempNum.append(infixCharArray[++i]);
                }
                //postfixStack.push(tempNum.toString());
                out.append(tempNum).append(" ");
            } else if (postfixStack.isEmpty() || isOpenPar(postfixStack.peek().charAt(0))) {
                //System.out.println("isempty or openpar: " + infixCharArray[i]);

                if (!isClosePar(infixCharArray[i])) {
                    postfixStack.push(String.valueOf(infixCharArray[i]));
                }
            } else if (isOpenPar(infixCharArray[i])) {
                //System.out.println("isopen: " + infixCharArray[i]);

                postfixStack.push(String.valueOf(infixCharArray[i]));

            } else if (isClosePar(infixCharArray[i])) {
                //System.out.println("isclose: " + infixCharArray[i]);

                while (!isOpenPar(postfixStack.peek().charAt(0))) {
                    out.append(postfixStack.pop()).append(" ");
                }
            } else if (isBinOperator(infixCharArray[i])) {
                //System.out.println("isbin: " + infixCharArray[i]);
                /*if ((int) infixCharArray[i] == 8211 || (int) infixCharArray[i] == 8212) {
                    infixCharArray[i] = (char) 45; // converts en and em dashes to hyphens
                }*/

                if (!(calcPrecedence(infixCharArray[i]) > calcPrecedence(postfixStack.peek().charAt(0)))) {
                    out.append(postfixStack.pop()).append(" ");
                }
                postfixStack.push(String.valueOf(infixCharArray[i]));

            } else if (isLetter(infixCharArray[i])) {
                out.append(infixCharArray[i]).append(" ");
            }
        }
        while (!postfixStack.isEmpty()) {
            if (isOpenPar(postfixStack.peek().charAt(0)) || isClosePar(postfixStack.peek().charAt(0))) {
                postfixStack.pop();
            } else {
                out.append(postfixStack.pop()).append(" ");
            }
        }

        while (isSpace(out.charAt(out.length() - 1))) { // deletes any spaces at the end
            out.deleteCharAt(out.length() - 1);
        }

        return out.toString();
    }

    ////////////////////////////////// Aiden was here /////////////////////////////////////
    static boolean isSpace(char test) {
        return (int) test == 32;
    }

    /*public static void test(String string, Stack<Double> stack) {
        System.out.println("String: " + string + "\nStack: " + stack + "\n");
    }*/

    public static double postfix_evaluation(String postfix) {
        int i;
        double answer = -1;
        Stack<Double> numeros = new Stack<>();

        while (postfix.length() != 1) {
            i = 0;

            //Operators Encountered
            if (isBinOperator(postfix.charAt(i))) {
                Double num2 = numeros.pop();
                Double num1 = numeros.pop();
                if (postfix.charAt(i) == 43) { //+
                    numeros.push(num1 + num2);
                } else if (postfix.charAt(0) == 45 || postfix.charAt(0) == 8212 || postfix.charAt(0) == 8211) { //-
                    numeros.push(num1 - num2);
                } else if (postfix.charAt(i) == 42) { //*
                    numeros.push(num1 * num2);
                } else if (postfix.charAt(i) == 47) { ///
                    numeros.push(num1 / num2);
                }

                if (postfix.length() != 1) {
                    postfix = postfix.substring(i + 2);
                }
                //test(postfix, numeros);


                //Pushes numbers to stack
            } else {
                while (!isSpace(postfix.charAt(i)) && !(postfix.length() == i + 1)) {
                    i++;
                }
                numeros.push(Double.valueOf(postfix.substring(0, i)));
                postfix = postfix.substring(i + 1);
                //test(postfix, numeros);
            }
        }

        while (!numeros.isEmpty() && numeros.size() != 1) {
            Double num2 = numeros.pop();
            Double num1 = numeros.pop();
            if (postfix.charAt(0) == 43) { //+
                numeros.push(num1 + num2);
            } else if (postfix.charAt(0) == 45 || postfix.charAt(0) == 8212 || postfix.charAt(0) == 8211) { //-
                numeros.push(num1 - num2);
            } else if (postfix.charAt(0) == 42) { //*
                numeros.push(num1 * num2);
            } else if (postfix.charAt(0) == 47) { ///
                numeros.push(num1 / num2);
            }

            if (postfix.length() != 1) {
                postfix = postfix.substring(1);
            } else {
                postfix = "";
            }
            //test(postfix, numeros);
        }

        if (numeros.size() == 1) {
            answer = numeros.pop();
        }
        return answer;


    }
}
