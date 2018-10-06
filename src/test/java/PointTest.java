import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PointTest {

    @Test
    public void testCompareTo() {
        Point a = new Point(0, 0);
        Point b = new Point(1, 1);
        Point c = new Point(0, 0);
        Point d = new Point(1, 0);

        assertTrue(a.compareTo(b) == Point.LESS);
        assertTrue( b.compareTo(a) == Point.GREATER);

        assertTrue( a.compareTo(d) == Point.LESS);
        assertTrue( d.compareTo(a) == Point.GREATER);

        assertTrue( a.compareTo(c) == Point.EQUAL);
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
}
