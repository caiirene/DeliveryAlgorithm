import java.util.LinkedList;

public class Point {

    private String name;
    private final int[] position;
    private LinkedList<Point> children;
    public boolean done;

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
        this.children.add(childNode);
    }

    public void finishDelivery(boolean done) {
        this.done = done;
    }

    public LinkedList<Point> getChildren() {
        return this.children;
    }

}
