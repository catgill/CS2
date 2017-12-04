

//12/4/2017
//Copied code from queue file from the announcements page on canvas
public class RingQueue<T> implements IQueue<T> {

    int front;
    int back;
    int size;
    T[] backingArray;


    public RingQueue(int size) {
        this.size = size;
        backingArray = (T[])new Object[size];
        front = 0;
        back  = 0;
    }


    public T dequeue() throws UnderFlowException {
        T ret = backingArray[front];
        backingArray[front] = null;
        front = (front+1)%size;
        return ret;
    }

    public void enqueue(T v) throws OverFlowException {
        backingArray[back] = v;
        back = (back+1)%size;
    }

}
