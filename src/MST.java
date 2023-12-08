import java.util.ArrayList;
import java.util.LinkedList;

public class MST {

    private ArrayList<Point> allDestination;
    private int nodeNumber;
    private int treeWeight = 0;
    private LinkedList<Point> APPRoute;
    private int APPRouteWeight;
    private Point from;
    private Point to;
    private final Point root;

    public MST(Point root) {
        this.root = root;
        nodeNumber = 1;
        APPRoute = new LinkedList<>();
        APPRoute.add(root);
        from = root;
    }

    public LinkedList<Point> getAPPRoute() {
        return APPRoute;
    }

    public Point getRoot() {
        return root;
    }

    public void addNode(int newEdgeWeight) {
        nodeNumber++;
        treeWeight += newEdgeWeight;
    }

    private int calculateDistance(Point point1, Point point2) {
        return Math.abs(point1.getPosition()[0] - point2.getPosition()[0])
                + Math.abs(point1.getPosition()[1] - point2.getPosition()[1]);
    }

    public void dfs(Point begin) {
        System.out.print("MST-dfs called" + "\n");
        this.from = begin;
        if (begin.getChildren().isEmpty()) {
            System.out.print("MST-dfs-reached leaf node " + begin.getName() + "\n");
            return;
        }
        else {
            for (Point c : begin.getChildren()) {
                this.to = c;
                this.APPRouteWeight+=calculateDistance(from,to);
                this.APPRoute.add(c);
                dfs(to);
            }
        }
    }

    public void finishRouteBackToRoot() {
        this.APPRouteWeight+=calculateDistance(this.from, root);
        this.APPRoute.add(root);
    }

}
