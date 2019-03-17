import static org.junit.Assert.assertEquals;

import edu.princeton.cs.algs4.StdDraw;
import java.util.List;
import org.junit.Test;

public class FastCollinearPointsTest {

  @Test
  public void testZeroSegments() {
    Point[] points = new Point[4];
    points[0] = new Point(10000,  10000);
    points[1] = new Point(14000, 10000);
    points[2] = new Point(10000, 14000);
    points[3] = new Point(14000, 14000);

    FastCollinearPoints fast = new FastCollinearPoints(points);
    assertEquals(0, fast.numberOfSegments());
  }

  @Test
  public void testHorizontalSegment() {
    Point[] points = new Point[4];
    points[0] = new Point(10000,  10000);
    points[1] = new Point(14000, 10000);
    points[2] = new Point(16000, 10000);
    points[3] = new Point(20000, 10000);

    FastCollinearPoints brute = new FastCollinearPoints(points);
    assertEquals(1, brute.numberOfSegments());
    TestUtils.printSegments(brute.segments());

  }

  @Test
  public void testVerticalSegment() {
    Point[] points = new Point[4];
    points[0] = new Point(10000,  10000);
    points[1] = new Point(10000, 12000);
    points[2] = new Point(10000, 14000);
    points[3] = new Point(10000, 16000);

    FastCollinearPoints brute = new FastCollinearPoints(points);
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

    FastCollinearPoints brute = new FastCollinearPoints(points);
    assertEquals(2, brute.numberOfSegments());
    TestUtils.printSegments(brute.segments());

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

    FastCollinearPoints brute = new FastCollinearPoints(points);
    assertEquals(3, brute.numberOfSegments());
    TestUtils.printSegments(brute.segments());

  }

  @Test
  public void testTwoSegmentsOneIntersection() {
    Point[] points = new Point[16];
    points[0] = new Point(10000,  10500);
    points[1] = new Point(10000, 12000);
    points[2] = new Point(10000, 14000);
    points[3] = new Point(10000, 16000);

    points[4] = new Point(10000,  17000);
    points[5] = new Point(10000, 18000);
    points[6] = new Point(10000, 19000);
    points[7] = new Point(10000, 20000);

    points[8] = new Point(7000, 12000);
    points[9] = new Point(16000, 12000);
    points[10] = new Point(18000, 12000);
    points[11] = new Point(20000, 12000);

    points[12] = new Point(22000, 12000);
    points[13] = new Point(24000, 12000);
    points[14] = new Point(26000, 12000);
    points[15] = new Point(28000, 12000);

    FastCollinearPoints brute = new FastCollinearPoints(points);
    assertEquals(2, brute.numberOfSegments());
    TestUtils.printSegments(brute.segments());

  }

  @Test
  public void testThreeSegmentsTwoIntersections() {
    Point[] points = new Point[12];
    points[0] = new Point(10000,  10500);
    points[1] = new Point(10000, 12000);
    points[2] = new Point(10000, 14000);
    points[3] = new Point(10000, 16000);

    points[4] = new Point(7000, 12000);
    points[5] = new Point(16000, 12000);
    points[6] = new Point(18000, 12000);
    points[7] = new Point(20000, 12000);

    points[8] = new Point(7000, 15000);
    points[9] = new Point(16000, 15000);
    points[10] = new Point(18000, 15000);
    points[11] = new Point(20000, 15000);

    FastCollinearPoints brute = new FastCollinearPoints(points);
    assertEquals(3, brute.numberOfSegments());
    TestUtils.printSegments(brute.segments());

  }

  @Test
  public void testThreeSegmentsThreeIntersections() {
    Point[] points = new Point[12];
    points[0] = new Point(10000,  10500);
    points[1] = new Point(10000, 12000);
    points[2] = new Point(10000, 14000);
    points[3] = new Point(10000, 16000);

    points[4] = new Point(7000, 12000);
    points[5] = new Point(16000, 12000);
    points[6] = new Point(18000, 12000);
    points[7] = new Point(20000, 12000);

    points[8] = new Point(7000, 15000);
    points[9] = new Point(10000, 12000);
    points[10] = new Point(12000, 10000);
    points[11] = new Point(14000, 8000);

    FastCollinearPoints brute = new FastCollinearPoints(points);
    assertEquals(3, brute.numberOfSegments());
    TestUtils.printSegments(brute.segments());

  }

  public static void main(String[] args) {
    Point[] points = new Point[16];
    points[0] = new Point(10000,  10500);
    points[1] = new Point(10000, 12000);
    points[2] = new Point(10000, 14000);
    points[3] = new Point(10000, 16000);

    points[4] = new Point(10000,  17000);
    points[5] = new Point(10000, 18000);
    points[6] = new Point(10000, 19000);
    points[7] = new Point(10000, 20000);

    points[8] = new Point(7000, 12000);
    points[9] = new Point(16000, 12000);
    points[10] = new Point(18000, 12000);
    points[11] = new Point(20000, 12000);

    points[12] = new Point(22000, 12000);
    points[13] = new Point(24000, 12000);
    points[14] = new Point(26000, 12000);
    points[15] = new Point(28000, 12000);

    FastCollinearPoints fast = new FastCollinearPoints(points);
    List<LineSegment> segmentList = fast.segments();
    System.out.println("expected: 2 " + "- actual: " + fast.numberOfSegments());

    //TestUtils.renderPoints(points);
    TestUtils.renderPoints(new Point[]{points[8], points[9], points[10], points[11]});

    TestUtils.renderSegments(segmentList);
    TestUtils.printSegments(segmentList);
    StdDraw.show();
  }

}
