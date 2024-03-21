package BinarySearchTree;

public class BinarySearchTree {
    public static void main(String[] args) {
        int[] array1 = {9, 5, 11, 17, 3, 10, 13};

        int[] array2 = {6, 5, 7, 2, 5, 8};

        System.out.println("array 1");
        Node head = createBinaryTree(array1);
        printBinaryTree(head);

        System.out.println();
        System.out.println("array 2");
        head = createBinaryTree(array2);
        printBinaryTree(head);
    }

    static Node createBinaryTree(int[] array) {
        Node head = new Node(array[0]);
        Node cursor = head;
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= cursor.getValue()) {
                if (cursor.getLeftNode() == null) {
                    cursor.setLeftNode(new Node(array[i]));
                    cursor = head;
                } else {
                    cursor = cursor.getLeftNode();
                    i--;
                }
            } else if (array[i] >= cursor.getValue()) {
                if (cursor.getRightNode() == null) {
                    cursor.setRightNode(new Node(array[i]));
                    cursor = head;
                } else {
                    cursor = cursor.getRightNode();
                    i--;
                }
            }
        }

        return head;
    }

    static void printBinaryTree(Node head){
        if(head == null) return;
        printBinaryTree(head.getLeftNode()); // thank you chatgpt for telling me to swap these two lines
        System.out.println(head);
        printBinaryTree(head.getRightNode());
    }
}
