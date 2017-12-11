

public class ArrayList<T> implements IList<T> {


  int size;
  T[] arrayList;
  int curr;
  T value;
  T[] list;
  int fetcher;
  int placer;

  public ArrayList() {
    size = 0;
    arrayList = (T[])new Object[size];
    curr = 0;
  }
  public boolean noValue() {
    if ((curr < 0) || (curr >= arrayList.length)) {
      return true;
    }
    return false;
  }

  public void insert(int idx, T v) {
    curr = idx;
    list = (T[])new Object[arrayList.length+1];
    for(int i = arrayList.length; i<curr; i++) {
        arrayList[i] = arrayList[i-1];
    }
    list[curr] = v;
    for (int i = arrayList.length; i>curr; i--)
    arrayList = list;
  }

  public void append(T v) {
    list = (T[])new Object[arrayList.length+1];
    for(int i=0; i<arrayList.length; i++) {
        list[i] = arrayList[i];
    }
    list[arrayList.length] = v;
    arrayList = list;
  }

  public void remove() {
    if (noValue() == true) {
      return;
    }
    for (int i = curr; i < arrayList.length; i++) {
      arrayList[i] = arrayList[i+1];
    }

  }

  public void remove(int idx) {
    if (noValue() == true) {
      return;
    }
    curr = idx;
    list = (T[])new Object[arrayList.length-1];
    for(int i=arrayList.length-1; i>-1; i--) {
        if(i==idx) {
        } else if(i<idx) {
            list[i] = arrayList[i];
        }else {
            list[i-1] = arrayList[i];
        }
    }
    arrayList = list;
  }

  // Needed a min function for the move method
  private int min(int a, int b) {
      if(a>b) { return b; }
      return a;
  }
  // Needed a max function for the move method
  private int max(int a, int b) {
      if(a<b) { return b; }
      return a;
  }

  public void move(int sidx,int didx) {
      list = (T[])new Object[arrayList.length];
      int fetcher = min(sidx,didx);
      int placer = max(sidx,didx);
      for(int i=0; i<arrayList.length; i++) {
          // before or after min/max of sidx,didx
          if(i<fetcher || i>placer) {
              list[i] = arrayList[i];
          } else {
              // What to do about the middle...
              if(i==didx) {
                  list[i]=arrayList[sidx];
              } else {
                  list[i+1]=arrayList[i];
              }
          }
      }
      arrayList = list;
  }

  /**
   * Fetches the value at the <i>current</i> index in the list.
   * @return the requested item
   */
  public T fetch() {
  //  System.out.println(curr);
    if (curr < 0 || curr > arrayList.length) {
      return null;
    }
    else{
    return arrayList[curr];
    }

  }

  /**
   * Fetches the value at a specific index in the list.
   * @param idx index of the item to return
   * @return the requested item
   */
  public T fetch(int idx) {
    if (curr < 0 || curr > arrayList.length) {
      return null;
    }
    return arrayList[idx];
  }

  /**
   * Advances the <i>current</i> index to the next index, if possible.
   */
  public void next() {
    curr ++;
  }

  /**
   * Advances the <i>current</i> index to the previous index, if possible.
   */
  public void prev() {
    curr --;
  }

  /**
   * Advances the <i>current</i> to the tail element
   */
  public void jumpToTail() {
    curr = arrayList.length-1;
  }

  /**
   * Advances the <i>current</i> to the head element
   */
  public void jumpToHead() {
    curr = 0;
  }

  /**
   * Returns the number of elements in the list
   */
  public int size() {
    return arrayList.length;
  }
}
