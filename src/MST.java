import java.util.ArrayList;

public class MST {

    private ArrayList<Point> allDestination;
    private int nodeNumber;

    private Point root;

    public MST(Point root) {
        this.root = root;
        nodeNumber = 1;
    }

    public Point getRoot() {
        return root;
    }

    public void addNode() {
        nodeNumber++;
    }

}
