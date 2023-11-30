import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private int[] origin = {0,0};
    private ArrayList<Point> routePlan;
    private ArrayList<Point> points;
    private HashMap<String, Integer> pointIndex; // Point名称到索引的映射
    private int[][] distanceMatrix; // 存储点与点之间的距离

    /**
     * 构造器
     * @param origin
     */
    public Graph(int[] origin) {
        this.origin = origin;
        this.routePlan = new ArrayList<>();
        this.distanceMatrix = new int[0][0]; // 初始化一个空的距离矩阵
    }

    // 更新距离矩阵
    private void updateDistanceMatrix(Point newPoint) {
        int newSize = distanceMatrix.length + 1;
        int[][] newMatrix = new int[newSize][newSize];

        // 复制旧的距离矩阵
        for (int i = 0; i < distanceMatrix.length; i++) {
            System.arraycopy(distanceMatrix[i], 0, newMatrix[i], 0, distanceMatrix[i].length);
        }

        // 计算新点到其他所有点的距离
        for (int i = 0; i < newSize - 1; i++) {
            newMatrix[i][newSize - 1] = newMatrix[newSize - 1][i] = calculateDistance(newPoint, routePlan.get(i));
        }

        distanceMatrix = newMatrix;
    }
    // 计算两点之间的距离
    private int calculateDistance(Point point1, Point point2) {
        return Math.abs(point1.getPosition()[0] - point2.getPosition()[0])
                + Math.abs(point1.getPosition()[1] - point2.getPosition()[1]);
    }

    /**
     * 在快递员接到任务时，调用此方法，将一个点加入到图中，并更新route
     * @param newPoint 新坐标
     */
    public void addPoint(Point newPoint) {
        points.add(newPoint); // 将新点加入到点列表中
        pointIndex.put(newPoint.getName(), points.size() - 1); // 更新点索引映射
        updateDistanceMatrix(newPoint); // 更新距离矩阵
        // 更新路线...
    }

    /**
     * 在快递员完成任务时，调用此方法，将一个点从图中删除，并更新route
     * @param xy 已完成的坐标
     */
    private void removePoint(int[] xy){

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
