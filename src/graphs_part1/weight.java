package graphs_part1;

public class weight {
    private final Node node1;
    private final Node node2;
    private final int weight;

    weight(Node node1, Node node2, int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }

}
