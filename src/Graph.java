import java.util.ArrayList;

public class Graph {
    private int[] origin = {0,0};
    private ArrayList<int[]> route;
    private ArrayList<Point> points;
    private int[][] distanceMatrix; // 存储点与点之间的距离

    /**
     * 构造器
     * @param origin
     */
    public Graph(int[] origin) {
        this.origin = origin;
        this.route = new ArrayList<>();
        this.distanceMatrix = new int[0][0]; // 初始化一个空的距离矩阵
    }

    // 更新距离矩阵
    private void updateDistanceMatrix(int[] newPoint) {
        int newSize = distanceMatrix.length + 1;
        int[][] newMatrix = new int[newSize][newSize];

        // 复制旧的距离矩阵
        for (int i = 0; i < distanceMatrix.length; i++) {
            System.arraycopy(distanceMatrix[i], 0, newMatrix[i], 0, distanceMatrix[i].length);
        }

        // 计算新点到其他所有点的距离
        for (int i = 0; i < newSize - 1; i++) {
            newMatrix[i][newSize - 1] = newMatrix[newSize - 1][i] = calculateDistance(newPoint, route.get(i));
        }

        distanceMatrix = newMatrix;
    }
    // 计算两点之间的距离
    private int calculateDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    /**
     * 在快递员接到任务时，调用此方法，将一个点加入到图中，并更新route
     * @param xy 新坐标
     */
    public void addPoint(int[] xy){

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
    private ArrayList<int[]>getRoute(){
        return this.route;
    }

    /**
     * 更新目前坐标（可能用不到这个方法）
     * @param xy 快递员当前位置
     */
    private void sendPosition(int[] xy){
        this.origin = xy;
    }

}
