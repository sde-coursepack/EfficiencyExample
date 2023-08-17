import java.util.ArrayList;
import java.util.List;

public class PointArrayList implements PointList{
    private final List<Point> points;

    public PointArrayList(ArrayList<Point> points) {
        this.points = points;
    }
    public PointArrayList() {
        points = new ArrayList<>();
    }

    public PointArrayList(int initialCapacity) {
        points = new ArrayList<>(initialCapacity);
    }

    @Override
    public void add(double xCoordinate, double yCoordinate) {
        points.add(new Point(xCoordinate, yCoordinate));
    }

    @Override
    public void add(Point point) {
        points.add(point);
    }

    @Override
    public Point get(int index) {
        return points.get(index);
    }

    @Override
    public int size() {
        return points.size();
    }

    @Override
    public double totalDistance() {
        double totalDistance = 0.0;
        //Iterate through all but the last point, getting distance to next point
        for (int i = 0; i < size()-1; i++) {
            Point firstPoint = points.get(i);
            Point secondPoint = points.get(i + 1);
            totalDistance += firstPoint.distanceTo(secondPoint);
        }
        return totalDistance;
    }
}
