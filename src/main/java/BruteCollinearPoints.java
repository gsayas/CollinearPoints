import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

  private List<Point> points;
  private List<LineSegment> segments;

  public BruteCollinearPoints(Point[] points) {
    checkArgument(points);
    initPoints(points);
    calculateSegments();
  }

  private void checkArgument(Point[] argPoints) {
    if (argPoints == null) {
      throw new java.lang.IllegalArgumentException();
    }

  }

  private void initPoints(Point[] argPoints) {
    this.points = new ArrayList<>();
    for (Point point : argPoints) {
      if (point == null || this.points.contains(point)) {
        throw new java.lang.IllegalArgumentException();
      }
      this.points.add(point);
    }
  }

  private void calculateSegments() {
    segments = new ArrayList<>();

    for (int i = 0; i < points.size(); i++) {
      for (int j = i + 1; j < points.size(); j++) {
        for (int k = j + 1; k < points.size(); k++) {
          if (isSegment(points.get(i), points.get(j), points.get(k))) {
            for (int m = k + 1; m < points.size(); m++) {
              if (isSegment(points.get(j), points.get(k), points.get(m))) {
                Point[] pointsInSegment = new Point[]{points.get(i), points.get(j), points.get(k),
                    points.get(m)};
                Arrays.sort(pointsInSegment);
                segments.add(new LineSegment(pointsInSegment[0], pointsInSegment[3]));
              }
            }
          }
        }
      }
    }
  }

  private boolean isSegment(Point point, Point point1, Point point2) {
    return point.slopeTo(point1) == point1.slopeTo(point2);
  }

  public int numberOfSegments() {
    return segments.size();
  }

  public LineSegment[] segments() {
    return segments.toArray(new LineSegment[segments.size()]);
  }
}
