import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List.of(10000000, 20000000, 30000000, 40000000, 50000000, 75000000, 100000000).forEach(Main::runBenchmark);
    }

    private static void runBenchmark(int size) {
        System.out.println("\nBenchmark for size = " + size);
        PointList coordinateArray = new CoordinateArray(size);
        PointList primitivesOnly = new CoordinateArray(size);
        PointList pointArrayList = new PointArrayList(size);
        double[] xCoordinates = randomArray(size);
        double[] yCoordinates = randomArray(size);
        for (int i = 0; i < size; i++) {
            coordinateArray.add(xCoordinates[i], yCoordinates[i]);
            pointArrayList.add(xCoordinates[i], yCoordinates[i]);
        }
        long coordinateTime = calculateDistanceTime(coordinateArray);
        System.out.printf("\tCoordinateArray distance = %12dms\n", coordinateTime);

        long arrayListTime = calculateDistanceTime(pointArrayList);
        System.out.printf("\tPointArrayList  distance = %12dms\n", arrayListTime);
    }
    private static long calculateDistanceTime(PointList pointList) {
        long startTimeNanoseconds = System.currentTimeMillis();
        pointList.totalDistance();
        long endTimeNanoseconds = System.currentTimeMillis();
        return endTimeNanoseconds - startTimeNanoseconds;
    }

    private static double[] randomArray(int size) {
        double[] array = new double[size];
        for(int i = 0; i < size; i++) {
            array[i] = Math.random();
        }
        return array;
    }
}
