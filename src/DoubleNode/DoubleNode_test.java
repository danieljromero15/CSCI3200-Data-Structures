package DoubleNode;

public class DoubleNode_test {
    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(7.77, null); // init
        head.addNodeAfter(5.62);
        head.addNodeAfter(2.50);
        head.addNodeAfter(9.03);
        head.addNodeAfter(42.69);
        System.out.println("Inital List:");
        print_list(head);

        head.removeNodeAfter();
        System.out.println("\nAfter removing the second element:");
        print_list(head);

        DoubleNode.listPosition(head, 2).setData(3.2);
        System.out.println("\nAfter changing the third element from 2.5 to 3.2:");
        print_list(head);

        DoubleNode.listPosition(head, DoubleNode.listLength(head)).setLink(new DoubleNode(100.07, null));
        System.out.println("\nAfter adding a new node with value 100.07 at the end:");
        print_list(head);

        DoubleNode newHead = DoubleNode.listCopy(head);
        System.out.println("\nPrinting a copy of the list:");
        print_list(newHead);

        DoubleNode[] newHeadPart = DoubleNode.listCopyPart(head.getLink(), DoubleNode.listPosition(head, DoubleNode.listLength(head)));
        System.out.println("\nPrinting a copy of part of the list:");
        print_list(newHeadPart[0]);

        System.out.println("\nFinding 3.2:");
        if (DoubleNode.listSearch(head, 3.2) != null) {
            System.out.println(DoubleNode.listSearch(head, 3.2).getData());
        }else{
            System.out.println("Could not find 3.2");
        }

        System.out.println("\nCopy of the list with its tail:");
        print_list(DoubleNode.listCopyWithTail(head)[0]);

        System.out.print("\nList tail: ");
        print_list(DoubleNode.listCopyWithTail(head)[1]);

    }

    public static void print_list(DoubleNode head) {
        for (DoubleNode traverse = head; traverse != null; traverse = traverse.getLink()) {
            System.out.println(traverse.getData());
        }
    }
}
