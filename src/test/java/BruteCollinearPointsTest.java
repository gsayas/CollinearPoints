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
        points[0] = new Point(10000,  10000);
        points[1] = new Point(10000, 12000);
        points[2] = new Point(10000, 14000);
        points[3] = new Point(10000, 16000);

        points[4] = new Point(10000,  10000);
        points[5] = new Point(14000, 10000);
        points[6] = new Point(16000, 10000);
        points[7] = new Point(20000, 10000);

        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        assertEquals(2, brute.numberOfSegments());
    }
}
