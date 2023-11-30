public class Point {

    private int[] position;
    private String name;

    public Point(int x, int y, String name) {
        this.position = new int[]{x, y};
        this.name = name;
    }

    public int[] getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
