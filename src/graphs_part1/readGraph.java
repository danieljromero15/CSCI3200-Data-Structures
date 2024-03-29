package graphs_part1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class readGraph {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] graph = parseGraph(new File("src/graphs_part1/graph2.txt"));

        for (int[] i : graph) {
            for (int j : i) {
                System.out.print(j + " ");
                if(j > 0){

                }
            }
            System.out.println();
        }
    }

    public static int[][] parseGraph(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        String in;

        int h = 0;
        int w = 0;

        while(scan.hasNextLine()) {
            in = scan.nextLine();
            String[] tempArray = in.split(",");
            w = tempArray.length;
            h++;
        }

        //System.out.println(w + " "+ h);

        scan.close();
        scan = new Scanner(file); // resets for parsing

        int[][] graph = new int[h][w];
        for (int i = 0; scan.hasNextLine(); i++) {
            in = scan.nextLine();
            String[] tempArray = in.split(",");
            for (int j = 0; j < tempArray.length; j++) {
                graph[i][j] = Integer.parseInt(tempArray[j]);
            }
        }
        scan.close();
        return graph;
    }
}
