import java.util.ArrayList;
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
  }

  public int numberOfSegments() {
    return segments.size();
  }

  public List<LineSegment> segments() {
    return segments;
  }

}
