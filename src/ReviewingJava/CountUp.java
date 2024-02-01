import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CountUp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPlease enter your input:");

        int num = scan.nextInt();

        print_evens(num);

    }

    public static void print_evens(int endNum){
        for(int i = 0; i <= endNum; ++i){
            if(i % 2 == 0){
                System.out.print(i + " ");
            }
        }
    }
}