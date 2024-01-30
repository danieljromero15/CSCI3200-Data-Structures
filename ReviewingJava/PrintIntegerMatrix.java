import java.lang.String;

public class PrintIntegerMatrix {
    public static void main(String[] args) {
        int[][] intArray = {{1,2,3},{4,5,6},{7,8,9}};

        print2DIntArray(intArray);

    }

    public static void printIntArray(int[] IntArrayParameter){
        for (int j : IntArrayParameter) {
            System.out.print(j + " ");
        }
    }
    public static void print2DIntArray(int[][] IntArrayParameter){
        for(int i = 0; i < IntArrayParameter[0].length; i++){
            for(int j = 0; j < IntArrayParameter.length; j++){
                System.out.print(IntArrayParameter[i][j] + " ");
            }
            System.out.println();
        }
    }
}
