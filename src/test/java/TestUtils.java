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

  static void renderSegments(List<LineSegment> segments) {
    segments.stream().forEach(line -> line.draw());
  }

  static void printSegments(List<LineSegment> segments) {
    segments.stream().forEach(System.out::println);
  }

  static void printPoints(Point[] points) {
      Arrays.stream(points).forEach(System.out::println);
  }
}
