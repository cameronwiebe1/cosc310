package chap17;

public class TreeDemo {
    public static void main(String[] args) {
        Tree<String> airports = new Tree<>("BHM");
        airports.addChild(airports.root(),"ATL");
        Tree<String>.TreeNode<String> msp = airports.addChild(airports.root(),"MSP");
        airports.addChild(msp,"JFK");
        airports.addChild(msp,"ORD");
        System.out.println(airports);
        System.out.println(airports.toString(msp, 0));
        System.out.println(airports.search("BHM"));
        System.out.println(airports.search("ABC"));
        System.out.println(airports.search("ORD"));

    }
}
