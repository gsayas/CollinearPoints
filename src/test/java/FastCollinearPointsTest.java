import static org.junit.Assert.assertEquals;

import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
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

  }

  public static void main(String[] args) {
    Point[] points = new Point[4];
    points[0] = new Point(10000,  10000);
    points[1] = new Point(14000, 10000);
    points[2] = new Point(16000, 10000);
    points[3] = new Point(20000, 10000);

    FastCollinearPoints fast = new FastCollinearPoints(points);
    List<LineSegment> segmentList = fast.segments();
    System.out.println("expected: 1 " + "- actual: " + fast.numberOfSegments());

    FastCollinearPointsTest.renderPoints(points);
    FastCollinearPointsTest.renderSegments(segmentList);
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
