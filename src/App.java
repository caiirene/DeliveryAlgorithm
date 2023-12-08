import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 这个APP类其实就是我们创建的任务管理器
 * 算是一个controller
 * 我们的main函数都是通过这个任务管理器进行运作
 */
public class App {
    private Point origin;
    private LinkedList<Point> routePlan; //从MST生成出真正的路线
    private ArrayList<Point> destinations = new ArrayList<>(); //应该用不到
    private MyMap map;
    private MST mst;

    /**
     * 构造器
     * @param
     */
    public App() {
        this.routePlan = new LinkedList<>();
        this.map = new MyMap(); // 初始化一个空的距离矩阵
        Point origin = new Point(0,0,"origin");
        this.origin = origin;
        this.map.addPoint(this.origin);
        this.mst = new MST(this.origin);
    }

    /**
     * 让map自行调用添加点的方法，
     * 仅仅是让map内添加点，并不会直接生成mst，或是往mst中添加node
     * @param newPoint
     */
    public void addOneDestiny(Point newPoint) {
        this.destinations.add(newPoint);
        this.map.addPoint(newPoint);
    }

    public ArrayList<Point> getDestinations() {
        return destinations;
    }

    /**
     * 在快递员完成任务时，调用此方法，将一个点从图中删除，并更新route
     * @param newPoint 已完成的点
     */
    public void finishOneDestiny(Point newPoint){

    }

    /**
     * 给出路线
     * @return route
     */
    public LinkedList<Point> getRoutePlan(){
        return this.routePlan;
    }

    /**
     * 生成MST
     * 前提：在我们已经完成所有点的添加后，再调用，且仅调用一次
     * 过程介绍：1.调取map的DM表格 2.将原点加入MST 3.while MST的大小还不够
     *         4.两个for循环，循环2D表格（其中row只扫描加入到MST的行，column扫描时判断i是否为已经加入inMST）
     *         5.找出最小边，记录：nearest为下一个加入MST的点，当前扫描row为其父。
     *         6.跳出两个for循环，将两个Point连接
     * @return 因为我们这一步操作其实是在将Point相连，并没有记录MST的总长度，所以没有返回值
     */
    public void generateMST() {
        HashSet<Point> inMST = new HashSet<Point>();
        inMST.add(origin);
        int mapSize = map.getMapSize();

        while (inMST.size()<mapSize) {
            Point parent = null;
            Point nearest = null;
            int minDis = Integer.MAX_VALUE;
            //开始扫描表格，寻找最小边
            for (Point p : inMST) {
                for (int i=1; i<mapSize; i++){
                    if (!inMST.contains(map.findPoint(i)) &&
                            map.getDistanceMatrix()[map.findIndex(p)][i]<minDis) {
                        minDis = map.getDistanceMatrix()[map.findIndex(p)][i];
                        parent = p;
                        nearest = map.findPoint(i);
                    }
                }
            }
            //找到最小边后，将它加进MST（其实就是把两个node连接起来,是直接调用Point的方法）
            assert parent != null;
            parent.connectWith(nearest);
            inMST.add(nearest);
            mst.addNode(minDis);//虽然无用
        }
        //while循环结束，没有其他操作
    }

    /**
     * 让MST自己生成路线，然后把它的路线copy到这里
     */
    public void generateRoute() {
        mst.dfs(this.origin);
        mst.finishRouteBackToRoot();
        this.routePlan = mst.getAPPRoute();
    }

}
