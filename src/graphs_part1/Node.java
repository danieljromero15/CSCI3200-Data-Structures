package graphs_part1;

import java.util.ArrayList;

public class Node {
    String name;
    ArrayList<weight> weights = new ArrayList<>();

    Node(String name){
        this.name = name;
    }

    void addWeight(weight weightToAdd){
        weights.add(weightToAdd);
    }
}
