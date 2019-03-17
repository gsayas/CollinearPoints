import java.util.ArrayList;
import java.util.List;

public class FastCollinearPoints {

  private List<Point> points;
  private List<LineSegment> segments;
  private List<String> keys;

  public FastCollinearPoints(Point[] points) {
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
    keys = new ArrayList<>();
    Point origin;
    List<Point> sortedOnOrigin = new ArrayList<>();

    for (int i = 0; i < points.size(); i++) {
      origin = points.get(i);
      sortedOnOrigin.addAll(points);
      sortedOnOrigin.sort(origin.slopeOrder());
      findAndSetSegments(origin, sortedOnOrigin);
      sortedOnOrigin.clear();
    }

  }

  private void findAndSetSegments(Point origin, List<Point> sortedOnOrigin) {
    List<Point> candidateSegment = new ArrayList<>();
    int currentIndex = 1;
    Point currentPoint;
    Point previousPoint;
    int size = sortedOnOrigin.size();

    while (currentIndex < size) {
      currentPoint = sortedOnOrigin.get(currentIndex);
      previousPoint = sortedOnOrigin.get(currentIndex - 1);

      if (areInSameSegment(origin, currentPoint, previousPoint)) {
        if (candidateSegment.isEmpty() && origin.compareTo(previousPoint) != 0) {
          candidateSegment.add(previousPoint);
        }
        candidateSegment.add(currentPoint);
      } else {
        if (isEnoughSegment(candidateSegment)) {
          candidateSegment.add(origin);
          addNewSegmentIfAbsent(candidateSegment);
        }
        candidateSegment.clear();
      }

      if (isEnoughSegment(candidateSegment) && currentIndex + 1 == size) {
        candidateSegment.add(origin);
        addNewSegmentIfAbsent(candidateSegment);
        candidateSegment.clear();
      }

      currentIndex++;
    }

  }

  private boolean areInSameSegment(Point origin, Point currentPoint, Point previousPoint) {
    return origin.compareTo(previousPoint) == 0 || origin.slopeTo(currentPoint) == origin
        .slopeTo(previousPoint);
  }

  private boolean isEnoughSegment(List<Point> candidateSegment) {
    return candidateSegment.size() >= 3;
  }

  private void addNewSegmentIfAbsent(List<Point> candidateSegment) {
    candidateSegment.sort(Point::compareTo);
    Point x = candidateSegment.get(0);
    Point y = candidateSegment.get(candidateSegment.size() - 1);
    LineSegment sortedSegment = new LineSegment(x, y);
    String key = segmentToString(x, y);
    putSegmentIfAbsent(key, sortedSegment);
  }

  private String segmentToString(Point x, Point y) {
    return x.toString() + " -- " + y.toString();
  }

  private void putSegmentIfAbsent(String key, LineSegment sortedSegment) {
    if (!keys.contains(key)) {
      keys.add(key);
      segments.add(sortedSegment);
    }
  }

  public int numberOfSegments() {
    return segments.size();
  }

  public LineSegment[] segments() {
    return segments.toArray(new LineSegment[segments.size()]);
  }

}
