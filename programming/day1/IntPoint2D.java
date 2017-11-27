import java.lang.Math;

public class IntPoint2D implements IIntPoint2D {

  int x;
  int y;

  public IntPoint2D(int a, int b) {
    this.x = a;
    this.y = b;
  }

  /**
   * @returns the X coordinate
   */
  public int getX() {
    return this.x;
  }
  /**
   * @returns the Y coordinate
   */
  public int getY() {
    return this.y;
  }

  /**
   * Computes the manhattan distance to another point.
   * formula: abs(x1-x2) + abs(y1-y2)
   * @param o the other point
   * @returns the manhattan distance
   */
  public int manhattanDistance(IIntPoint2D o) {
    return Math.abs(this.x - o.getX()) + Math.abs(this.y - o.getY());
  }
  /**
   * Computes the euclidean distance to another point.
   * formula: sqrt((x1-x2)^2 + (y1-y2)^2)
   * @param o the other point
   * @returns the euclidean distance
   */
  public double distance(IIntPoint2D o) {
    return Math.sqrt(this.x - o.getX())^2 + Math.sqrt(this.y - o.getY())^2;
  }

  // The following methods make JAVA objects better behaved
  /**
   * Converts a point object to a string of the form (X,Y)
   * @returns human friendly point representation
   */
  public String toString() {
    return "(" + getX() + ", " + getY() + ")";
  }
  /**
   * Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
   * @returns true if this point is the same as point o
   */
  public boolean equals(Object o) {
    if (this.x == o.getX() && this.y == o.getY()) {
      return true;
    }
    else {
      return false;
    }
  }
  /**
   * Hashcode to support some standard library data structures
   * formula: (x<<16)+y
   * @returns the hashcode for the point
   */
  public int hashcode();
}
