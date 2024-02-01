import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        //checks if input string is a palindrome
        Scanner scan = new Scanner(System.in);

        String s1 = scan.nextLine();

        boolean palindrome = isPalindrome(s1);

        if(palindrome){
            System.out.println(s1 + " is a palindrome!");
        }else{
            System.out.println(s1 + " is not a palindrome.");
        }

    }

    public static boolean isPalindrome(String stringIn){
        for(int i = 0; i < stringIn.length() / 2; i++){
            if(stringIn.charAt(i) != stringIn.charAt(stringIn.length() - i - 1)
            ){
                return false;
            }
        }
        return true;
    }
}
