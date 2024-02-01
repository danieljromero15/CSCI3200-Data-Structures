package big_O_proj.In_class;

public class method3_test {
    public static void main(String[] args) {

        //System.out.println("Method 1:"); // Big O is O(log(n))
        //for (int n = 1; n < 1000; n++) {
            //System.out.println(n + "," + method1(n) + "," + Math.ceil(Math.log(n) / Math.log(2)));
        //}

        //System.out.println("Method 2:"); // Big O is O(n)
        //for (int n = 1; n < 1000; n++) {System.out.println(n + "\t" + method2(n) + "\t" + 2*n);}

        System.out.println("Method 3:"); // O(n)
        for (int n = 1; n < 1000; n++) {
            System.out.println(n + "\t" + method3(n) + "\t" + 2*Math.sqrt(n));
        }

        //the graph of this is insane and I don't even want to start to find a formula that matches up but the complexity is definitely O(n^3)
        //for (int n = 1; n < 1000; n++) {System.out.println(n + "," + alg6(n) + "," + 2*n);}

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

    public static int alg6 (int n) {
        int steps = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i*i; j++){
                steps++;
                if(j % i == 0){
                    for(int k = 0; k < j; k++){
                        steps++;
                    }
                }
            }
        }
        return steps;
    }
}
