import java.util.ArrayList;
import java.util.HashMap;

public class Map {

    private ArrayList<Point> allPoints; // 这里存储所有点，但基本没用
    private HashMap<String, Integer> pointIndex; // Point名称到索引的映射
    private int[][] distanceMatrix; // 存储点与点之间的距离s

    private int calculateDistance(Point point1, Point point2) {
        return Math.abs(point1.getPosition()[0] - point2.getPosition()[0])
                + Math.abs(point1.getPosition()[1] - point2.getPosition()[1]);
    }

    /**
     * 其实就是先复制原来的表格，再添加新的行列
     * @param newPoint
     */
    private void updateMap(Point newPoint) {
        int newSize = distanceMatrix.length + 1;
        int[][] newMatrix = new int[newSize][newSize];

        // 复制旧的距离矩阵
        for (int i = 0; i < distanceMatrix.length; i++) {
            System.arraycopy(distanceMatrix[i], 0, newMatrix[i], 0, distanceMatrix[i].length);
        }

        // 计算新点到其他所有点的距离
        for (int i = 0; i < newSize - 1; i++) {
            newMatrix[i][newSize - 1] = newMatrix[newSize - 1][i] = calculateDistance(newPoint, allPoints.get(i));
        }

        distanceMatrix = newMatrix;
    }

    /**
     * 先添加点进记录，然后更新地图
     * @param newPoint
     */
    public void addPoint(Point newPoint) {
        allPoints.add(newPoint); // 将新点加入到点列表中
        pointIndex.put(newPoint.getName(), allPoints.size() - 1); // 更新点索引映射
        updateMap(newPoint); // 更新距离矩阵
    }

}
