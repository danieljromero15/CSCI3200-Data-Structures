package BinarySearchTreeProject;

public class tree_tester {
    public static void main(String[] args) {
        btnode_int root = new btnode_int(5);
        root.setLeft(new btnode_int(3));
        root.getLeft().setLeft(new btnode_int(1));
        // TODO add more manually

        System.out.println("Part 1 in-order-print:");
        root.inOrderPrint();

        System.out.println();
        System.out.println("Part 2 result of search in binary search tree");
        System.out.println("result: " + btnode_int.Search_in_binary_tree(root, 1));

        System.out.println();
        int[] arr2 = {5, 3, 1, 9, 6, 4};
        btnode_int tree2 = build_tree(arr2);
        System.out.println("Part 3 Original Array:");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Part 3 in-order-print:");
        tree2.inOrderPrint();
    }
    
    public static btnode_int build_tree(int[] arr){
        btnode_int head = new btnode_int(arr[0]);
        btnode_int cursor = head;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= cursor.getData()) {
                if (cursor.getLeft() == null) {
                    cursor.setLeft(new btnode_int(arr[i]));
                    cursor = head;
                } else {
                    cursor = cursor.getLeft();
                    i--;
                }
            } else if (arr[i] >= cursor.getData()) {
                if (cursor.getRight() == null) {
                    cursor.setRight(new btnode_int(arr[i]));
                    cursor = head;
                } else {
                    cursor = cursor.getRight();
                    i--;
                }
            }
        }

        return head;
    }
}
