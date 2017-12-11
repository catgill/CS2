


public class DLink<T> implements IDLink<T> {

  T value;
  IDLink<T> next;
  IDLink<T> prev;

  public DLink() {
    value = null;
    next = null;
    prev = null;
  }

  public T getValue() {
    return value;
  }

  /**
   * Sets the current value for this link cell
   * @param v the value to place in this cell
   */
  public void setValue(T v) {
    value = v;
  }

  /**
   * Gets the next cell in the list
   * @return the cell
   */
  public IDLink<T> getNext() {
    return next;
  }

  /**
   * Gets the previous cell in the list
   * @return the cell
   */
  public IDLink<T> getPrev() {
    return prev;
  }

  /**
   * Sets the next cell in the list
   * @param c the next cell
   */
  public void setNext(IDLink<T> c) {
    next = c;
  }

  /**
   * Sets the next cell in the list
   * @param c the next cell
   */
  public void setPrev(IDLink<T> c) {
    prev = c;
  }
}
