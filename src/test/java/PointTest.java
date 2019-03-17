import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PointTest {

    private static int LESS = -1;
    private static int EQUAL = 0;
    private static int GREATER = 1;

    @Test
    public void testCompareTo() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(0, 0);
        Point d = new Point(1, 0);

        assertTrue(a.compareTo(b) == PointTest.LESS);
        assertTrue( b.compareTo(a) == PointTest.GREATER);

        assertTrue( a.compareTo(d) == PointTest.LESS);
        assertTrue( d.compareTo(a) == PointTest.GREATER);

        assertTrue( a.compareTo(c) == PointTest.EQUAL);
    }

    @Test
    public void testSlopeTo() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(1, 0);
        Point d = new Point(0, 1);
        Point e = new Point(0, 0);

        assertEquals(1.0, a.slopeTo(b), 0.0);
        assertEquals(+0.0, a.slopeTo(c), 0.0);
        assertEquals(Double.POSITIVE_INFINITY, a.slopeTo(d), 0.0);
        assertEquals(Double.NEGATIVE_INFINITY, a.slopeTo(e), 0.0);

        assertFalse(Double.POSITIVE_INFINITY == new Double(+0.0));
        assertFalse(Double.POSITIVE_INFINITY == Double.NEGATIVE_INFINITY);
        assertFalse(new Double(-0.0) == new Double(+0.0));
        //assertFalse(-0.0 == +0.0); TRUE
    }

    @Test
    public void testSlopeOrder() {
        Point[] points = new Point[8];
        points[0] = new Point(10000,  10500);
        points[1] = new Point(10000, 12000);
        points[2] = new Point(10000, 14000);
        points[3] = new Point(10000, 16000);

        points[4] = new Point(7000, 12000);
        points[5] = new Point(16000, 12000);
        points[6] = new Point(18000, 12000);
        points[7] = new Point(20000, 12000);


        Comparator<Point> comparator = points[4].slopeOrder();
        //assertEquals(1, comparator.compare(points[0], points[1]));

        Arrays.sort(points, comparator);
        TestUtils.printPoints(points);
        TestUtils.renderPoints(Arrays.copyOfRange(points,4, 4));
        StdDraw.show();
    }

    public static void main(String[] args) {
        Point[] points = new Point[8];
        points[0] = new Point(10000,  10500);
        points[1] = new Point(10000, 12000);
        points[2] = new Point(10000, 14000);
        points[3] = new Point(10000, 16000);

        points[4] = new Point(7000, 12000);
        points[5] = new Point(16000, 12000);
        points[6] = new Point(18000, 12000);
        points[7] = new Point(20000, 12000);


        Comparator<Point> comparator = points[1].slopeOrder();
        //System.out.println("expected: 1 " + "- actual: " + comparator.compare(points[0], points[1]));
        //TestUtils.renderPoints(new Point[]{points[4], points[0], points[1]});

        Arrays.sort(points, comparator);
        TestUtils.printPoints(points);
        TestUtils.renderPoints(points);
        StdDraw.show();
    }

}
