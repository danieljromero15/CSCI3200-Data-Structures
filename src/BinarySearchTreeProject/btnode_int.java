package BinarySearchTreeProject;

public class btnode_int {
    private int data;
    private btnode_int left;
    private btnode_int right;

    btnode_int(int data, btnode_int left, btnode_int right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    btnode_int(int initialData){
        this(initialData, null, null);
    }

    @Override
    public String toString(){
        return String.valueOf(this.getData());
    }

    public void setData(int newData) {
        this.data = newData;
    }

    public void setLeft(btnode_int newLeft) {
        this.left = newLeft;
    }

    public void setRight(btnode_int newRight) {
        this.right = newRight;
    }

    public int getData() {
        return data;
    }

    public btnode_int getLeft() {
        return left;
    }

    public btnode_int getRight() {
        return right;
    }

    public void inOrderPrint(){
        if(left != null){
            left.inOrderPrint();
        }
        System.out.println(data);
        if(right != null){
            right.inOrderPrint();//test
        }
    }

    public static btnode_int Search_in_binary_tree(btnode_int root, int key){
        System.out.println(root);
        if(root == null || root.getData() == key){
            return root;
        }else if(key < root.getData()){
            return Search_in_binary_tree(root.getLeft(), key);
        }else{
            return Search_in_binary_tree(root.getRight(), key);
        }
    }
}
