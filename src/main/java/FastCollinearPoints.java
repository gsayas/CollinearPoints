import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

  private List<Point> points;
  private List<LineSegment> segments;
  private List<String> keys;

  public FastCollinearPoints(Point[] points) {
    this.points = new ArrayList<>();
    this.points.addAll(Arrays.asList(points));
    calculateSegments();
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

    while( currentIndex < size ) {
      currentPoint = sortedOnOrigin.get(currentIndex);
      previousPoint = sortedOnOrigin.get(currentIndex - 1);

      if( areInSameSegment(origin, currentPoint, previousPoint) ) {
        if (candidateSegment.size() == 0 && origin.compareTo(previousPoint) != 0) candidateSegment.add(previousPoint);
        candidateSegment.add(currentPoint);
      } else {
        if ( isEnoughSegment(candidateSegment) ) {
          candidateSegment.add(origin);
          addNewSegmentIfAbsent(candidateSegment);
        }
        candidateSegment.clear();
      }


      if ( isEnoughSegment(candidateSegment) && currentIndex + 1 == size ) {
        candidateSegment.add(origin);
        addNewSegmentIfAbsent(candidateSegment);
        candidateSegment.clear();
      }

      currentIndex++;
    }

  }

  private boolean areInSameSegment(Point origin, Point currentPoint, Point previousPoint) {
    return origin.compareTo(previousPoint) == 0 || origin.slopeTo(currentPoint) == origin.slopeTo(previousPoint);
  }

  private boolean isEnoughSegment(List<Point> candidateSegment) {
    return candidateSegment.size() >= 3;
  }

  private void addNewSegmentIfAbsent(List<Point> candidateSegment ) {
    candidateSegment.sort(Point::compareTo);
    LineSegment sortedSegment = new LineSegment(candidateSegment.get(0),
        candidateSegment.get(candidateSegment.size() - 1));
    String key = sortedSegment.toString();
    putSegmentIfAbsent(key, sortedSegment);
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
