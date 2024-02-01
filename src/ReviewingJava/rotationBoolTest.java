import java.util.Scanner;

public class rotationBoolTest {
    public static void main(String[] args) {
        String s1;
        String s2;
        Scanner scan = new Scanner(System.in);

        System.out.println("String 1:");
        s1 = scan.nextLine();
        System.out.println("String 2:");
        s2 = scan.nextLine();

        System.out.println(isRotation(s1, s2));

    }

    public static boolean isRotation(String s1, String s2){
        for(int i = 0; i < s1.length(); i++){
            if(rotate(s1,i).equals(s2)){
                return true;
            }
        }
        return false;
    }

    public static String rotate(String s, int r){
        int stringLength = s.length();

        String beginString = s.substring(0, stringLength-r);
        String endString = s.substring(stringLength - r);

        return endString.concat(beginString);
    }
}
