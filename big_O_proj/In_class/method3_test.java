package In_class;

public class method3_test {
    public static void main(String[] args) {

        System.out.println("Method 1:");
        for (int n = 1; n < 1000; n++) {
            System.out.println(n + "\t" + method1(n) + "\t" + 2*Math.sqrt(n));
        }

        System.out.println("Method 2:");
        for (int n = 1; n < 1000; n++) {System.out.println(n + "\t" + method2(n) + "\t" + 2*Math.sqrt(n));
        }

        System.out.println("Method 3:");
        for (int n = 1; n < 1000; n++) {
            System.out.println(n + "\t" + method3(n) + "\t" + 2*Math.sqrt(n));
        }
    }

    public static int method1(int n){
        int steps = 0;
        while(n>0){
            steps++;
            n = n/2;
        }
        return steps;
    }

    public static int method2(int n){
        int steps = 0;
        while(n>0){
            for (int k = 0; k < n; k++) {
                steps++;
            }
            n = n/2;
        }
        return steps;
    }

    public static int method3(int x){
        int steps = 0;
        int tmp = 1;
        int i = 0;
        while(tmp <= x){
            steps++;
            i++;
            tmp = i*i;
        }
        return steps;
    }
}
