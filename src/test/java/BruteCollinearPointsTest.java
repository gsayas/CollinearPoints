import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BruteCollinearPointsTest {

    @Test
    public void testZeroSegments() {
        Point[] points = new Point[4];
        points[0] = new Point(10000,  10000);
        points[1] = new Point(14000, 10000);
        points[2] = new Point(10000, 14000);
        points[3] = new Point(14000, 14000);

        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        assertEquals(0, brute.numberOfSegments());
    }

    @Test
    public void testHorizontalSegment() {
        Point[] points = new Point[4];
        points[0] = new Point(10000,  10000);
        points[1] = new Point(14000, 10000);
        points[2] = new Point(16000, 10000);
        points[3] = new Point(20000, 10000);

        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        assertEquals(1, brute.numberOfSegments());

    }

    @Test
    public void testVerticalSegment() {
        Point[] points = new Point[4];
        points[0] = new Point(10000,  10000);
        points[1] = new Point(10000, 12000);
        points[2] = new Point(10000, 14000);
        points[3] = new Point(10000, 16000);

        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        assertEquals(1, brute.numberOfSegments());
    }

    @Test
    public void testTwoSegments() {
        Point[] points = new Point[8];
        points[0] = new Point(10000,  10500);
        points[1] = new Point(10000, 12000);
        points[2] = new Point(10000, 14000);
        points[3] = new Point(10000, 16000);
        points[4] = new Point(14000, 10000);
        points[5] = new Point(16000, 10000);
        points[6] = new Point(18000, 10000);
        points[7] = new Point(20000, 10000);

        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        assertEquals(2, brute.numberOfSegments());

    }

    @Test
    public void testThreeSegments() {
        Point[] points = new Point[12];
        points[0] = new Point(10000,  10500);
        points[1] = new Point(10000, 12000);
        points[2] = new Point(10000, 14000);
        points[3] = new Point(10000, 16000);

        points[4] = new Point(14000, 10000);
        points[5] = new Point(16000, 10000);
        points[6] = new Point(18000, 10000);
        points[7] = new Point(20000, 10000);

        points[8] = new Point(14800, 14800);
        points[9] = new Point(16800, 16800);
        points[10] = new Point(18800, 18800);
        points[11] = new Point(20800, 20800);

        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        assertEquals(3, brute.numberOfSegments());

    }

    public static void main(String[] args) {
        Point[] points = new Point[12];
        points[0] = new Point(10000,  10500);
        points[1] = new Point(10000, 12000);
        points[2] = new Point(10000, 14000);
        points[3] = new Point(10000, 16000);

        points[4] = new Point(14000, 10000);
        points[5] = new Point(16000, 10000);
        points[6] = new Point(18000, 10000);
        points[7] = new Point(20000, 10000);

        points[8] = new Point(14800, 14800);
        points[9] = new Point(16800, 16800);
        points[10] = new Point(18800, 18800);
        points[11] = new Point(20800, 20800);

        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        List<LineSegment> segmentList = brute.segments();
        System.out.println("expected: 3 " + "- actual: " + brute.numberOfSegments());

        BruteCollinearPointsTest.renderPoints(points);
        BruteCollinearPointsTest.renderSegments(segmentList);
        StdDraw.show();
    }

    private static void renderPoints(Point[] points) {
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        Arrays.stream(points).forEach(point -> point.draw());
        StdDraw.show();
    }

    private static void renderSegments(List<LineSegment> segments) {
        segments.stream().forEach(line -> line.draw());
    }


}
