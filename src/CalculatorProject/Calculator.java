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
        char[] infixCharArray = infix.toCharArray();

        for (int i = 0; i < infixCharArray.length; i++) {
            if (isNumber(infixCharArray[i])) {
                StringBuilder tempNum = new StringBuilder(String.valueOf(infixCharArray[i]));
                while (i + 1 < infixCharArray.length && isNumber(infixCharArray[i + 1])) {
                    tempNum.append(infixCharArray[++i]);
                }
                //postfixStack.push(tempNum.toString());
                out.append(tempNum).append(" ");
            } else if (postfixStack.isEmpty() || isOpenPar(postfixStack.peek().charAt(0))) {
                postfixStack.push(String.valueOf(infixCharArray[i]));
            } else if (isOpenPar(infixCharArray[i])) {
                postfixStack.push(String.valueOf(infixCharArray[i]));

            } else if (isClosePar(infixCharArray[i])) {
                while (!isOpenPar(postfixStack.peek().charAt(0))) {
                    out.append(postfixStack.pop());//.append(" ");
                }
            } else if (isBinOperator(infixCharArray[i])) {
                if ((int) infixCharArray[i] == 8211 || (int) infixCharArray[i] == 8212) {
                    infixCharArray[i] = (char) 45; // converts en and em dashes to hyphens
                }

                /*if (calcPrecedence(infixCharArray[i]) > calcPrecedence(postfixStack.peek().charAt(0))) {
                    postfixStack.push(String.valueOf(infixCharArray[i]));
                } else {
                    out.append(postfixStack.pop()).append(" ");
                    postfixStack.push(String.valueOf(infixCharArray[i]));
                }*/
                if(!(calcPrecedence(infixCharArray[i]) > calcPrecedence(postfixStack.peek().charAt(0)))) {
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

        return out.toString();
    }

    public static void main(String[] args) {
        String result = infix_to_postfix("( 3 – 23 ) * 4 + 100"); // 3 23 - 4 * 100 +

        System.out.println(result);
    }
}
