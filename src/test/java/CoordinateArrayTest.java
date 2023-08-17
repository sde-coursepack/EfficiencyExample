import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateArrayTest {
    @Test
    void constructorInitialSize() {
        Path testList = new CoordinateArray(10);
        assertEquals(testList.size(), 0);
    }
    @Test
    void addPointSizeIncrease() {
        Path testList = new CoordinateArray(2);
        Point p = new Point(1.0, 2.0);
        testList.add(p);
        assertEquals(1, testList.size());
    }

    @Test
    void getPoint() {
        Path testList = new CoordinateArray(2);

        Point p = new Point(1.0, 2.0);
        testList.add(p);

        assertEquals(p, testList.get(0));
    }

    @Test
    void size() {
        List<Point> inputPoints = List.of(
                new Point(0,0),
                new Point(1, 0),
                new Point(1, 1)
        );
        Path testList = new CoordinateArray(3);
        inputPoints.forEach(testList::add);
        assertEquals(3, testList.size());
    }

    @Test
    void totalDistance() {
        List<Point> inputPoints = List.of(
                new Point(0,0), //distance to next point = 1.0
                new Point(1, 0), //distance to next point = 1.0
                new Point(1, 1), //distance to next point = 5.0
                new Point(4, 5) // totalDistance = 7.0
        );
        Path testList = new CoordinateArray(4);
        inputPoints.forEach(testList::add);
        assertEquals(7.0, testList.totalDistance(), 1e-14);
    }

    @Test
    void totalDistanceEmpty() {
        Path testList = new PathPointList();
        assertEquals(0.0, testList.totalDistance());
    }

    @Test
    void totalDistanceSizeOne() {
        Path testList = new PathPointList(1);
        testList.add(new Point(3.0, 4.0));
        assertEquals(0.0, testList.totalDistance());
    }
}