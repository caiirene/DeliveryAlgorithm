import java.util.ArrayList;
import java.util.HashMap;

public class Map {

    private ArrayList<Point> allPoints; // 这里存储所有点，但似乎没用
    private HashMap<Point, Integer> pointIndex; // Point名称到索引的映射
    private int[][] distanceMatrix; // 存储点与点之间的距离s

    /**
     * 仅仅用于计算两点间距离，计算方法：
     * 因为我们假设马路横平竖直，没有交叉形式的马路，所以两点间距离为X轴和Y轴差的总和。
     * @param point1
     * @param point2
     * @return 距离
     */
    private int calculateDistance(Point point1, Point point2) {
        return Math.abs(point1.getPosition()[0] - point2.getPosition()[0])
                + Math.abs(point1.getPosition()[1] - point2.getPosition()[1]);
    }

    /**
     * 先添加点进记录，然后更为地图新添内容，可以当做解锁新地图
     * 其实就是先复制原来的表格，再添加新的行列
     * @param newPoint
     */
    public void addPoint(Point newPoint) {
        allPoints.add(newPoint); // 将新点加入到点列表中
        pointIndex.put(newPoint.getName(), allPoints.size() - 1); // 更新点索引映射

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
     * 在寻找一个目的地的index时调用
     * @param point
     * @return index
     */
    public int findIndexByName(Point point) {
        return pointIndex.get(point);
    }

    public int getDistance(Point pointA, Point pointB){
        int indexA = pointIndex.get(pointA);
        int indexB = pointIndex.get(pointB);
        return distanceMatrix[indexA][indexB];
    }

}
