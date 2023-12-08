import java.util.ArrayList;
import java.util.HashMap;

/**
 * Map类用来表示我们自制的地图，
 * 地图内容很简单，每个点都可以连接到所有点，它们之间的边就是距离
 * 方法：1.添加新点 2.获取已经保存过的两点间的距离
 */
public class Map {

    private ArrayList<Point> allPoints; // 这里存储所有点，但似乎没用
    private HashMap<Point, Integer> pointIndex; // Point名称到索引的映射
    //private int[][] distanceMatrix; // 存储点与点之间的距离s
    private DistanceTableCell[][] distanceMatrix; // 存储点与点之间的距离s
    private class DistanceTableCell {
        public boolean cellUsed;
        public int cellInt;
        public DistanceTableCell(int distance){
            cellInt = distance;
            cellUsed = false;
        }
    }

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
        pointIndex.put(newPoint, allPoints.size() - 1); // 更新点索引映射

        int newSize = distanceMatrix.length + 1;
        DistanceTableCell[][] newMatrix = new DistanceTableCell[newSize][newSize];

        // 复制旧的距离矩阵
        for (int i = 0; i < distanceMatrix.length; i++) {
            System.arraycopy(distanceMatrix[i], 0, newMatrix[i], 0, distanceMatrix[i].length);
        }

        // 计算新点到其他所有点的距离
        for (int i = 0; i < newSize - 1; i++) {
            newMatrix[i][newSize - 1] = newMatrix[newSize - 1][i] =
                    new DistanceTableCell(calculateDistance(newPoint, allPoints.get(i)));
        }

        distanceMatrix = newMatrix;
    }

    /**
     * 在寻找一个目的地的index时调用
     * @param point
     * @return index
     */
    public int findIndex(Point point) {
        return pointIndex.get(point);
    }

    /**
     * 获取两个已存的点的距离，虽然我不知道这样做的意义是什么，但，先这样写上吧
     * @param pointA
     * @param pointB
     * @return 距离
     */
    public int getDistance(Point pointA, Point pointB){
        int indexA = pointIndex.get(pointA);
        int indexB = pointIndex.get(pointB);
        return distanceMatrix[indexA][indexB].cellInt;
    }

}
