/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

  private static final int LESS = -1;
  private static final int EQUAL = 0;
  private static final int GREATER = 1;

  private final int x;     // x-coordinate of this point
  private final int y;     // y-coordinate of this point

  /**
   * Initializes a new point.
   *
   * @param x the <em>x</em>-coordinate of the point
   * @param y the <em>y</em>-coordinate of the point
   */
  public Point(int x, int y) {
    /* DO NOT MODIFY */
    this.x = x;
    this.y = y;
  }

  /**
   * Draws this point to standard draw.
   */
  public void draw() {
    /* DO NOT MODIFY */
    StdDraw.point(x, y);
  }

    /* public void drawWithinfo(int index) {
        StdDraw.point(x, y);
        String info = ((Integer)index).toString() + ": " + "(" + x + ", " + y + ")";
        StdDraw.text(x + 500, y + 500, info);
    } */

  /**
   * Draws the line segment between this point and the specified point to standard draw.
   *
   * @param that the other point
   */
  public void drawTo(Point that) {
    /* DO NOT MODIFY */
    StdDraw.line(this.x, this.y, that.x, that.y);
  }

  /**
   * Returns the slope between this point and the specified point. Formally, if the two points are
   * (x0, y0) and (x1, y1), then the slope is (y1 - y0) / (x1 - x0). For completeness, the slope is
   * defined to be +0.0 if the line segment connecting the two points is horizontal;
   * Double.POSITIVE_INFINITY if the line segment is vertical; and Double.NEGATIVE_INFINITY if (x0,
   * y0) and (x1, y1) are equal.
   *
   * @param that the other point
   * @return the slope between this point and the specified point
   */
  public double slopeTo(Point that) {
    if (that.y == this.y && this.x == that.x) {
      return Double.NEGATIVE_INFINITY;
    } else if (that.y == this.y) {
      return +0.0;
    } else if (this.x == that.x) {
      return Double.POSITIVE_INFINITY;
    } else {
      return (double) (that.y - this.y) / (that.x - this.x);
    }
  }

  public int compareTo(Point that) {
    if (this.y != that.y) {
      return this.y < that.y ? LESS : GREATER;
    } else if (this.x != that.x) {
      return this.x < that.x ? LESS : GREATER;
    } else {
      return EQUAL;
    }
  }

  /**
   * Compares two points by the slope they make with this point. The slope is defined as in the
   * slopeTo() method.
   *
   * @return the Comparator that defines this ordering on points
   */
  public Comparator<Point> slopeOrder() {
    return new CompareBySlopes();
  }


  private final class CompareBySlopes implements Comparator<Point> {

    public int compare(Point argX, Point argY) {
      if (Point.this.slopeTo(argX) == Point.this.slopeTo(argY)) {
        return 0;
      } else {
        return Point.this.slopeTo(argX) < Point.this.slopeTo(argY) ? -1 : 1;
      }
    }
  }


  /**
   * Returns a string representation of this point. This method is provide for debugging; your
   * program should not rely on the format of the string representation.
   *
   * @return a string representation of this point
   */
  public String toString() {
    /* DO NOT MODIFY */
    return "(" + x + ", " + y + ")";
  }

  /**
   * Unit tests the Point data type.
   */
  public static void main(String[] args) {
    // read the n points from a file

    Point[] points = new Point[4];
    points[0] = new Point(10000, 10000);
    points[1] = new Point(14000, 10000);
    points[2] = new Point(10000, 14000);
    points[3] = new Point(14000, 14000);

    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    Arrays.stream(points).forEach(point -> point.draw());
    StdDraw.show();

    points[0].drawTo(points[1]);
    points[0].drawTo(points[2]);
    points[1].drawTo(points[3]);
    points[2].drawTo(points[3]);

    StdDraw.show();

  }

}