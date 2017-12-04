

public class Queue<T> implements IQueue {


  public T dequeue() throws UnderFlowException {
    if(size==0) { throw new UnderFlowException(); }
    T r = queue[0];
    for(int i=1; i<size; i++) {
        queue[i-1] = queue[i];
    }
    size--;
    return r;
  }
}
