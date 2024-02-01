package In_class;

public class alg3_test {
    public static void main(String[] args) {
        for (int n = 1; n < 100; n++) {
            System.out.println(n + "\t" + alg3(n) + "\t" + n*n + "\t" + n*n*n + "\t" + n*n*n*n);
        }
    }

    public static int alg3(int n){
        int steps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                steps++;
            }
        }
        return steps;
    }
}
