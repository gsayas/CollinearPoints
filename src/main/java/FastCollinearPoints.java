import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

  private Point[] points;
  private List<LineSegment> segments;

  public FastCollinearPoints(Point[] points) {
    this.points = points;
    calculateSegments();
  }

  private void calculateSegments() {
    segments = new ArrayList<>();
    Point origin;
    Point[] sortedOnOrigin;

    for (int i = 0; i < points.length; i++) {
      origin = points[i];
      sortedOnOrigin = points.clone();
      Arrays.sort(sortedOnOrigin, origin.slopeOrder());
      findAndSetSegments(origin, sortedOnOrigin);
    }

  }

  private void findAndSetSegments(Point origin, Point[] sortedOnOrigin) {
    List<Point> candidateSegment = new ArrayList<>();
    int currentIndex = 1;
    Point currentPoint;
    Point previousPoint;
    int size = sortedOnOrigin.length;

    while( currentIndex < size ) {
      currentPoint = sortedOnOrigin[currentIndex];
      previousPoint = sortedOnOrigin[currentIndex - 1];

      if( areInSameSegment(origin, currentPoint, previousPoint) ) {
        if (candidateSegment.size() == 0) candidateSegment.add(previousPoint);
        candidateSegment.add(currentPoint);
      } else {
        if ( isEnoughSegment(candidateSegment) ) {
          candidateSegment.add(origin);
          addNewSegment(candidateSegment);
        }
        candidateSegment.clear();
        currentIndex++;
      }

      currentIndex++;
    }

  }

  private boolean areInSameSegment(Point origin, Point currentPoint, Point previousPoint) {
    return origin.slopeTo(currentPoint) == origin.slopeTo(previousPoint);
  }

  private boolean isEnoughSegment(List<Point> candidateSegment) {
    return candidateSegment.size() > 3;
  }

  private void addNewSegment(List<Point> candidateSegment) {
    candidateSegment.sort(Point::compareTo);
    segments.add(new LineSegment(candidateSegment.get(0),
        candidateSegment.get(candidateSegment.size() - 1)));
  }

  public int numberOfSegments() {
    return segments.size();
  }

  public List<LineSegment> segments() {
    return segments;
  }

}
