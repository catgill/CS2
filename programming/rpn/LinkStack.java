

public class LinkStack<T> implements IStack<T> {
  Cell<T> top;
  double size; //is the current size of the stack


  public LinkStack(double siz) {
    size = 0;
    top = null;
  }
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public void push(T v) throws OverFlowException {
    Cell<T> n = new Cell<T>(v, top);
    top = n;
    size++;
  }
  public T pop() throws UnderFlowException {
    if (isEmpty() == true) {
      throw new UnderFlowException();
    }
    T v = top.getValue();
    top = top.getPointer();
    size --;
    return v;
  }
}
