

public class LinkStack<T> implements IStack<T> {
  Cell<T> top;
  int size; //is the current size of the stack


  public LinkStack() {
    size = 0;
    top = null;
  }

  public void push(T v) throws OverFlowException {
    Cell<T> n = new Cell<T>(v, top);
    top = n;
    size++;
  }
  public T pop() throws UnderFlowException {
    T v = top.getValue();
    top = top.getPointer;
    size --;
    return v;
  }
  public static void main(String[] argv) {
    LinkStack<Integer> ls = new LinkStack<Integer>();
    ls.push(1);
    ls.push(2);
    System.out.println(ls.pop());
    System.out.println(ls.pop());
  }
}
