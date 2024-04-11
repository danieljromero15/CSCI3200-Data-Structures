package quicksort;

import java.util.Arrays;

public class quicksort_alg {
    public static void main(String[] args) {
        int[] data = {76, 34, 88, 13, 21, 10, 99};
        System.out.println(Arrays.toString(data));
        int pivotIndex = partition(data, 0, 7);
        System.out.println(pivotIndex);
        System.out.println(Arrays.toString(data));

        quicksort(data, 0, 7);
        System.out.println(Arrays.toString(data));
    }

    public static int partition(int[] data, int first, int n) {
        int pivot = data[first];
        int tooBigIndex = first + 1;
        int tooSmallIndex = first + n - 1;

        while (tooBigIndex <= tooSmallIndex) {
            while(tooBigIndex < n && data[tooBigIndex] <= pivot) {
                tooBigIndex++;
            }
            while(data[tooSmallIndex] > pivot) {
                tooSmallIndex--;
            }
            if(tooBigIndex < tooSmallIndex) {
                int temp = data[tooBigIndex];
                data[tooBigIndex] = data[tooSmallIndex];
                data[tooSmallIndex] = temp;
            }
        }

        data[first] = data[tooSmallIndex];
        data[tooSmallIndex] = pivot;

        return tooSmallIndex;
    }

    public static void quicksort(int[] data, int first, int n){
        int pivotIndex;
        int n1;
        int n2;

        if(n > 1){
            pivotIndex = partition(data, first, n);

            n1 = pivotIndex - first;
            n2 = n - n1 - 1;

            quicksort(data, first, n1);
            quicksort(data, pivotIndex + 1, n2);
        }
    }
}
