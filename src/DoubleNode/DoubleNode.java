package DoubleNode;

import java.util.ArrayList;

public class DoubleNode {
    private double data;
    private DoubleNode link;


    public DoubleNode(double initialData, DoubleNode initialLink) { // 5 usages
        data = initialData;
        link = initialLink;
    }

    public double getData() { // 2 usages
        return data;
    }

    public DoubleNode getLink() { // 2 usages
        return link;
    }

    public void removeNodeAfter() { // 1 usage
        link = link.link;
    }


    public void setData(double newData) { // 1 usage
        data = newData;
    }

    public void setLink(DoubleNode newLink) { // 1 usage
        link = newLink;
    }

    public void addNodeAfter(double item) { // 6 usages
        link = new DoubleNode(item, link);
    }

    public static DoubleNode listCopy(DoubleNode source) { // 1 usage
        ArrayList<DoubleNode> sourceCopy = new ArrayList<>();
        for(DoubleNode cursor = source; cursor.link != null; cursor = cursor.link){
            sourceCopy.add(cursor);
        }
        return sourceCopy.get(0);
    }


    public static DoubleNode[] listCopyWithTail(DoubleNode source) { // 2 usages
        DoubleNode copyHead, copyTail;
        DoubleNode[] answer = new DoubleNode[2];

        // Handle the special case of the empty list
        if (source == null) {
            return answer;
        }

        // Make the first node for the newly created list
        copyHead = new DoubleNode(source.data, null);
        copyTail = copyHead;

        // Make the rest of the nodes for the newly created list
        while (source.link != null) {
            source = source.link;
            copyTail.addNodeAfter(source.data);
            copyTail = copyTail.link;
        }

        // Return the head and tail references
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }


    public static int listLength(DoubleNode head) { // 2 usages
        int numOfNodes = 0;
        DoubleNode cursor = head;
        while(cursor.link != null){
            cursor = cursor.link;
            numOfNodes++;
        }
        return numOfNodes;
    }


    public static DoubleNode[] listCopyPart(DoubleNode start, DoubleNode end) { // 1 usage
        DoubleNode copyHead, copyTail;
        DoubleNode[] answer = new DoubleNode[2];

        // Handle the special case of the empty list
        if (start == null) {
            return answer;
        }

        // Make the first node for the newly created list
        copyHead = new DoubleNode(start.data, null);
        copyTail = copyHead;

        // Make the rest of the nodes for the newly created list
        while (start.link != end) {
            start = start.link;
            copyTail.addNodeAfter(start.data);
            copyTail = copyTail.link;
        }

        // Return the head and tail references
        answer[0] = copyHead;
        answer[1] = copyTail;
        return answer;
    }


    public static DoubleNode listPosition(DoubleNode head, int position) { // 3 usages
        DoubleNode cursor = head;
        for(int i = 0; i < position; i++){
            cursor = cursor.link;
        }
        return cursor;
    }

    public static DoubleNode listSearch(DoubleNode head, double target) { // 1 usage
        DoubleNode cursor;

        for (cursor = head; cursor != null; cursor = cursor.link) {
            if (target == cursor.data) {
                return cursor;
            }
        }

        return null;
    }

}
