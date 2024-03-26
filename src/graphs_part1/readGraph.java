package graphs_part1;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

public class readGraph {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] graph = parseGraph(new File("src/graphs_part1/graph1_mx.txt"));

        for (int i = 0; i < graph[0].length; i++) {
            for (int j : graph[i]) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static int[][] parseGraph(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String in;
        int[][] graph = new int[4][4];
        for(int i = 0; scan.hasNextLine(); i++){
            in = scan.nextLine();
            String[] tempArray = in.split(",");
            for(int j = 0; j < tempArray.length; j++){
                graph[i][j] = Integer.parseInt(tempArray[j]);
            }
        }
        scan.close();
        return graph;
    }
}
