import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private Point[] points;
    //private int numberOfSegments;
    private List<LineSegment> segments;

    public BruteCollinearPoints(Point[] points) {
        this.points = points;
        calculateSegments();
    }

    private void calculateSegments() {
        //numberOfSegments = 0;
        segments = new ArrayList<>();

        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                for(int k=j+1; k<points.length; k++){
                    if(isSegment(points[i], points[j], points[k])){
                        for (int l = k+1; l < points.length; l++) {
                            if(isSegment(points[j], points[k], points[l])){
                                //numberOfSegments++;
                                Point[] pointsInSegment = new Point[]{points[i], points[j], points[k], points[l]};
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
        /*if(point.slopeTo(point1) == point1.slopeTo(point2)){
            System.out.println(point + " - " + point1 + " - " + point2);
        }*/
        return point.slopeTo(point1) == point1.slopeTo(point2);
    }

    public int numberOfSegments() {

        segments.stream().forEach(System.out::println);
        return segments.size();
    }
}
