

//12/4/2017
//Copied code from class

public class Cell<T> {
  T value;
  Cell<T> pointer;
  public Cell(T v, Cell<T> p) {
    value = v;
    pointer = p;
  }
  public void setValue(T v) {
    value = v;
  }
  public T getValue() {
    return value;
  }
  public void setPointer(Cell<T> p) {
    pointer = p;
  }
  public Cell<T> getPointer() {
    return pointer;
  }
}
