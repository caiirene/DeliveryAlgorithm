import java.util.ArrayList;
import java.util.HashMap;

public class App {
    private int[] origin = {0,0};
    private ArrayList<Point> routePlan;
    private ArrayList<Point> points;
    private HashMap<String, Integer> pointIndex; // Point名称到索引的映射
    private Map map;

    /**
     * 构造器
     * @param origin
     */
    public App(int[] origin) {
        this.origin = origin;
        this.routePlan = new ArrayList<>();
        this.map = new Map(); // 初始化一个空的距离矩阵
    }

    /**
     * 让map自行调用添加点的方法
     * @param newPoint
     */
    public void addOneDestiny(Point newPoint) {
        this.map.addPoint(newPoint);
    }

    /**
     * 在快递员完成任务时，调用此方法，将一个点从图中删除，并更新route
     * @param newPoint 已完成的点
     */
    private void finishOneDestiny(Point newPoint){

    }

    /**
     * 给出路线
     * @return route
     */
    private ArrayList<Point>getRoute(){
        return this.routePlan;
    }

    /**
     * 更新目前坐标（可能用不到这个方法）
     * @param xy 快递员当前位置
     */
    private void sendPosition(int[] xy){
        this.origin = xy;
    }

}
