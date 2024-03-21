package BinarySearchTree;

public class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;

    Node(int value, Node leftNode, Node rightNode){
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    Node(int value){
        this(value, null, null);
    }

    @Override
    public String toString(){
        return String.valueOf(this.getValue());
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
}
