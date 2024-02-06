package big_O_proj.In_class.StringNode;

public class Weather {
    public static void main(String[] args) {
        String[] arr = {"snow", "rain", "sleet"};
        StringNode p, q, r, s;

        p = new StringNode("hail");
        for (int i = 0; i < 3; i++) {
            p.setLink(new StringNode(arr[i], p.getLink()));
        }
        System.out.println("Answer 1");
        for (r = p; r != null; r = r.getLink()) {
            System.out.println(r.getData());
        }
        r = p;
        while (r.getLink() != null) {
            r = r.getLink();
        }
        r.setLink(p);
        q = r.getLink();
        q = q.getLink();
        System.out.println("Answer 2 " + q.getData());

        s = new StringNode("cloudy", q);
        r = r.getLink();
        r.setLink(s);
        System.out.println("Answer 3 " + q.getData());
        System.out.println("Answer 4 " + p.getData());

        System.out.println("Answer 5 ");
        while (s != p) {
            System.out.println(s.getData());
            s = s.getLink();
        }
    }
}
