import java.lang.Math;
/**
 * An interface for 2D grids that store char values
 */
public class IntGrid2D implements IIntGrid2D {

  int upper_x;
  int upper_y;
  int lower_x;
  int lower_y;
  char fill_value;
  int len_col;
  int len_row;
  char[][] squares;
  char value;
  int new_lower_x;
  int new_lower_y;
  int new_upper_x;
  int new_upper_y;
  int setx;
  int sety;


    public IntGrid2D(int u_x, int u_y, int l_x, int l_y, char fill) {
      upper_x = u_x;
      upper_y = u_y;
      lower_x = l_x;
      lower_y = l_y;
      fill_value = fill;
      if (upper_x < 0) {
        new_upper_x = 0;
        new_lower_x += lower_x + Math.abs(upper_x);
      }
      if (lower_y < 0) {
        new_lower_y += 0;
        new_upper_y += upper_y + Math.abs(lower_y);
      }
      len_col = new_lower_x - new_upper_x;
      len_row = new_upper_y - new_lower_y;
      squares = new char[len_col+8][len_row+8];
      for (int i = 0; i < len_col; i++) {
        for (int j = 0; j < len_row; j++) {
          squares[i][j] = fill_value;
        }
      }
    }

    /**
     * Sets the value at a point on the grid, replacing the previous value if any.
     * @param p The coordinate to set the value of
     * @param v The value to set at the coordinate
     */
    public void setPoint(IIntPoint2D p, char v) {
      System.out.println(p);
      setx = p.getX();
      sety = p.getY();
      fill_value = v;
      if (upper_x < 0) {
        setx += Math.abs(setx);
      }
      if (lower_y < 0) {
        sety += Math.abs(sety);
      }

      squares[setx][sety] = fill_value;
    }

    /**
     * Gets the value at a point on the grid
     * @param p The coordinate to get the value of
     * @returns the stored value
     */
    public char getPoint(IIntPoint2D p) {
      return squares[Math.abs(p.getX())][Math.abs(p.getY())];
    }

    /**
     * Gets the coordinate for the upper left most location
     * @returns an IIntPoint that is the coordinate of the upper left corner
     */
    public IIntPoint2D getUpperLeftCorner() {
      IIntPoint2D left_bounds = new IntPoint2D(upper_x, upper_y);
      return left_bounds;
    }

    /**
     * Gets the coordinate for the lower right most location
     * @returns an IIntPoint that is the lower right corner
     */
    public IIntPoint2D getLowerRightCorner() {
      IIntPoint2D right_bounds = new IntPoint2D(lower_x, lower_y);
      return right_bounds;
    }

}
