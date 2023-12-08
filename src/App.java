import java.util.ArrayList;
import java.util.HashMap;

public class App {
    private Point origin;
    private ArrayList<Point> routePlan; //从MST生成出真正的路线
    private ArrayList<Point> destinations; //应该用不到
    private Map map;
    private MST mst;

    /**
     * 构造器
     * @param
     */
    public App() {
        this.routePlan = new ArrayList<>();
        this.map = new Map(); // 初始化一个空的距离矩阵
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
        this.map.addPoint(newPoint);
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
    public ArrayList<Point> getRoutePlan(){
        return this.routePlan;
    }

    /**
     * 生成MST
     * 前提：在我们已经完成所有点的添加后，再调用，且仅调用一次
     *
     * @return
     */
    public ArrayList<Point> generateMST() {

        return new ArrayList<Point>();
    }


    private int findMinInRow(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            // 数组为空或第一行为空，返回一个错误标识或抛出异常
            return Integer.MAX_VALUE; // 或者抛出一个异常
        }

        int minValue = array[0][0]; // 假设第一个元素是最小的
        int minIndex = 0; // 最小值的索引

        // 遍历第一行的每个元素
        for (int i = 1; i < array[0].length; i++) {
            if (array[0][i] < minValue) {
                minValue = array[0][i]; // 更新最小值
                minIndex = i; // 更新最小值的索引
            }
        }

        // 这里返回最小值，如果需要索引也可以返回
        return minValue;
    }



}
