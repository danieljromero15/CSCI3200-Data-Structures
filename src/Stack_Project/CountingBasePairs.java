package Stack_Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.exit;

public class CountingBasePairs {
    public static void main(String[] args) {
        File file = null;
        Scanner scan = null;
        try {
            file = new File("data_for_stack_project_RNA_structures.txt");
            if (args.length > 0) {
                //System.out.println("more than 1!");
                //System.out.println(args[0]);
                file = new File(args[0]);
            }
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            //System.out.println(e);
            System.out.println("File " + file + " not found");
            exit(404);
        }

        Stack<Integer> S1 = new Stack<>();
        int[] total_num_of_pairs = {0, 0, 0};

        while (scan.hasNextLine()) {
            int[] num_of_pairs = {0, 0, 0}; // AU/UA; CG/GC; GU/UG
            String sequence = scan.nextLine();
            String dot_bracket = scan.nextLine();

            for (int i = 0; i < dot_bracket.length(); i++) {
                if (dot_bracket.charAt(i) == '(') {
                    S1.push(i);
                }
                if (dot_bracket.charAt(i) == ')') {
                    int close_index = i;
                    int open_index = S1.pop();

                    String basePair = sequence.charAt(open_index) + " " + sequence.charAt(close_index);
                    //System.out.println(open_index + " " + close_index);
                    switch (basePair) {
                        case "A U":
                        case "U A":
                            num_of_pairs[0]++;
                            break;
                        case "C G":
                        case "G C":
                            num_of_pairs[1]++;
                            break;
                        case "G U":
                        case "U G":
                            num_of_pairs[2]++;
                    }

                    //System.out.println(basePair);
                }
            }
            /*System.out.println("AU: " + num_of_pairs[0]);
            System.out.println("CG: " + num_of_pairs[1]);
            System.out.println("GU: " + num_of_pairs[2]);*/

            total_num_of_pairs[0] += num_of_pairs[0];
            total_num_of_pairs[1] += num_of_pairs[1];
            total_num_of_pairs[2] += num_of_pairs[2];
        }

        System.out.println();
        System.out.println("total AU: " + total_num_of_pairs[0]);
        System.out.println("total CG: " + total_num_of_pairs[1]);
        System.out.println("total GU: " + total_num_of_pairs[2]);

        int sum = Arrays.stream(total_num_of_pairs).sum();

        System.out.println();
        System.out.println("Percentages:");
        System.out.println("AU: " + ((double)total_num_of_pairs[0] / sum) * 100);
        System.out.println("CG: " + ((double)total_num_of_pairs[1] / sum) * 100);
        System.out.println("GU: " + ((double)total_num_of_pairs[2] / sum) * 100);
    }
}
