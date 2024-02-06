package big_O_proj.In_class;

public class StringNode {

    private String data;
    private StringNode link;

    public StringNode(){
        data = null;
        link = null;
    }

    public StringNode(String data){
        this.data = data;
        link = null;
    }

    public StringNode(String data, StringNode link){
        this.data = data;
        this.link = link;
    }

    public void setLink(StringNode newLink){
        link = newLink;
    }

    public void setData(String newData){
        data = newData;
    }

    public StringNode getLink() {
        return link;
    }

    public String getData() {
        return data;
    }

    public static void main(String[] args) {
        StringNode str = new StringNode();
        str.setData("Dino");
        StringNode str2 = new StringNode("Fred", str);
        StringNode str3 = new StringNode("Barney", str2);
        StringNode str4 = str3;
        while(str4 != null){
            System.out.println(str4.getData());
            str4 = str4.getLink();
        }
    }
}
