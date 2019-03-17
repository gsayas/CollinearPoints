import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.util.List;

public class TestUtils {

  static void renderPoints(Point[] points) {
    // draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (int i = 0; i < points.length; i++) {
      points[i].draw();
      //points[i].drawWithinfo(i);
    }
  }

  static void renderSegments(LineSegment[] segments) {
    Arrays.stream(segments).forEach(line -> line.draw());
  }

  static void printSegments(LineSegment[] segments) {
    Arrays.stream(segments).forEach(System.out::println);
  }

  static void printPoints(Point[] points) {
      Arrays.stream(points).forEach(System.out::println);
  }
}
