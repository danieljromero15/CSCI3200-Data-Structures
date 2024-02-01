package Homework;

public class Time_Complexity {
    public static void main(String[] args) {
        for (int n = 1; n < 1000; n++) {
            System.out.println(n + "," + method_A(n) + "," + (Math.sqrt(n) + 1));
            //System.out.println(n + "," + method_B(n) + "," + n*n);
            //System.out.println(n + "," + method_C(n) + "," + 10*n);
            //System.out.println(n + "," + method_D(n) + "," + 2*(n+1));
        }

    }

    public static int method_A(int n){
        int steps = 0;

        for (int i = 0; i*i < n; i++) {
            steps++;
        }
        return steps;
    }

    public static int method_B(int n){
        int steps = 0;

        for (int i = 0; Math.sqrt(i) < n; i++) {
            steps++;
        }
        return steps;
    }

    public static int method_C(int n){
        int steps = 0;
        int tmp_max = n;
        while(n > 0){
            for (int k = 0; k < tmp_max; k++) {
                steps++;
            }
            n = n / 2;
        }
        return steps;
    }

    public static int method_D(int x){
        int steps = 0;
        int tmp = 1;
        int i = 0;
        while(tmp <= x){
            steps++;
            i++;
            tmp = i / 2;
        }
        return steps;
    }
}
