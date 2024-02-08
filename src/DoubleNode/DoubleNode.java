package DoubleNode;

public class DoubleNode {
    private double data;
    private DoubleNode link;


    public DoubleNode(double initialData, DoubleNode initialLink) {
        data = initialData;
        link = initialLink;
    }

    public double getData() {
        return data;
    }

    public DoubleNode getLink() {
        return link;
    }

    public void removeNodeAfter() {
        link = link.link;
    }


    public void setData(double newData) {
        data = newData;
    }

    public void setLink(DoubleNode newLink) {
        link = newLink;
    }

    public void addNodeAfter(double item) {
        link = new IntNode(item, link);
    }

    public static DoubleNode listCopy(DoubleNode source) {

    }


    public static DoubleNode[] listCopyWithTail(DoubleNode source) {
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


    public static int listLength(DoubleNode head) {
        int numOfNodes = 0;
        DoubleNode cursor = head;
        while(cursor.link != null){
            cursor = cursor.link;
            numOfNodes++;
        }
        return numOfNodes;
    }


    public static DoubleNode[] listCopyPart(DoubleNode start, DoubleNode end) {

    }


    public static DoubleNode listPosition(DoubleNode head, int position) {
        DoubleNode cursor = head;
        for(int i = 0; i < position; i++){
            cursor = cursor.link;
        }
        return cursor;
    }

    public static DoubleNode listSearch(DoubleNode head, double target) {
        DoubleNode cursor;

        for (cursor = head; cursor != null; cursor = cursor.link) {
            if (target == cursor.data) {
                return cursor;
            }
        }

        return null;
    }

}
