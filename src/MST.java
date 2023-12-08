import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 这个MST类看似有些鸡肋，
 * 但它的核心用处是：用深度优先算法，从tree得到真正的路线（使用approximation算法）
 */
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

    /**
     * 没啥用的东西
     * @param newEdgeWeight
     */
    public void addNode(int newEdgeWeight) {
        nodeNumber++;
        treeWeight += newEdgeWeight;
    }

    /**
     * 单纯的计算距离的函数
     * @param point1
     * @param point2
     * @return
     */
    private int calculateDistance(Point point1, Point point2) {
        return Math.abs(point1.getPosition()[0] - point2.getPosition()[0])
                + Math.abs(point1.getPosition()[1] - point2.getPosition()[1]);
    }

    /**
     * 在函数外记录每一小段的起始点和终点，
     * 然后深度优先地往下走，
     * 无路可走后返回上层，连接下一个child
     * @param begin
     */
    public void dfs(Point begin) {
        //System.out.print("MST-dfs called" + "\n");
        this.from = begin;
        if (begin.getChildren().isEmpty()) {
            //System.out.print("MST-dfs-reached leaf node " + begin.getName() + "\n");
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

    /**
     * 在完成dfs，走完所有node后，需要连回root
     */
    public void finishRouteBackToRoot() {
        this.APPRouteWeight+=calculateDistance(this.from, root);
        this.APPRoute.add(root);
    }

}
