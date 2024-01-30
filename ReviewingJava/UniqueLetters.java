import java.util.Scanner;

public class UniqueLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();

        boolean isUnique = isUniqueLetters(s1);
        if (isUnique) { // shouldn't spit out this warning but okay
            System.out.println("All letters in " + s1 + " are unique");
        } else if (!isUnique) {
            System.out.println(s1 + " does not contain unique letters");
        }
    }

    public static boolean isUniqueLetters(String stringIn){
        int initial = 0;
        int stringLength = stringIn.length();

        for(int i=initial; i < stringLength; i++){
            int letterIndex = stringIn.lastIndexOf(stringIn.charAt(i));
            //System.out.println("char: " + stringIn.charAt(i) + "; index: " + letterIndex);
            if(i != letterIndex){
                return false;
            }
        }

        return true;
    }
}
