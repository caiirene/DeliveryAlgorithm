import java.util.LinkedList;

/**
 * 这个Point类首先记录了一个目的地的基本信息，如xy坐标，以及名字
 * 然后更重要的是，它会在生成MST时记录tree的结构，也就是每个点有自己的children
 */
public class Point {

    private String name;
    private final int[] position;
    private LinkedList<Point> children = new LinkedList<>();
    public boolean done; //似乎用不上,因为在dfs中，不会有回路

    public Point(int x, int y, String name) {
        this.position = new int[]{x, y};
        this.name = name;
    }

    public int[] getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void connectWith(Point childNode){
        System.out.print("Point-getConnection: "+ name + childNode.getName() + "\n");
        this.children.add(childNode);
    }

    public void finishDelivery(boolean done) {
        this.done = done;
    }

    public LinkedList<Point> getChildren() {
        return this.children;
    }

}
