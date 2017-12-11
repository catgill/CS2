


  /** Linked list implementation */
public class SingleLinkList<T> implements IList<T> {

  ISLink<T> head;
  ISLink<T> tail;
  ISLink<T> curr;

  public SingleLinkList() {
      // Creates new empty links for the head and tail. Not counted
      // as in the list, but can make the implementation easier.
      head=new SLink<T>();
      tail=new SLink<T>();
      head.setNext(tail);
      tail.setNext(tail);
      curr=head;
  }

  /**
   * Inserts an item at a specific index in the list
   * @param idx where the item should be inserted
   * @param v the value to insert
   */
  public void insert(int idx, T v) {
      // Generate the new link to insert
      ISLink<T> n = new SLink<T>();
    n.setValue(v);
      // Handle the head as a special case
    if(idx==0) {
        n.setNext(head.getNext());
        head.setNext(n);
        return;
    }
      // Advance to the right place for insertion
    ISLink<T> s = head;
    for(int i=0; i<idx; i++) {
        s = s.getNext();
    }
      // Execute the insertion... No check to make sure the tail is protected
    n.setNext(s.getNext());
    s.setNext(n);
  }

/**
 * Adds an item to the end of list. Called 'Add' in class, but more usually called
 * append in other libraries. Moves <i>current</i> to the end of the list.
 * @param v Item to add
 */
public void append(T v) {
      // Make the new node
    ISLink<T> n = new SLink();
    n.setValue(v);

    if (head == tail) {
      head = n;
    }
    while (curr.getNext() != null) {
      curr = curr.getNext();
    }
    curr = n;
    ISLink p = returnTail();
      // Jump to the end of the list
      // Insert the node
    n.setNext(p);
    p.setNext(n);
    curr=n;
}


/**
 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
 * the previous item in the list, if such element exists.
 */
public void remove() {
      // Get the nodes on each side of the node to remove
    ISLink<T> p = head;
    ISLink<T> n=curr.getNext();
    for (int i=0; p !=NULL && i < curr-1; i++)
         p = p.getNext;

      // Link them to each other
    p.setNext(n);
      // Move curr back one so that it points to the correct element as
      // specified in the comment
    curr=p;
}

/**
 * Removes the item at a specific index
 * @param idx index of item to remove
 */
public void remove(int idx) {
      // Advance curr to the node to remove
    fetch(idx);
      // Call the remove method
    remove();
}

/**
 * Changes the location of an existing element in the list
 * @param sidx - The initial index for the element to move
 * @param didx - The final index for the element to move
 */
public void move(int sidx, int didx) {
      // Advance curr to the node to remove and capture the value
    T t=fetch(sidx);
      // Remove the node
    remove();
      // Put the value into the correct location in the list
    insert(didx, t);
}

/**
 * Fetches the value at the <i>current</i> index in the list.
 * @return the requested item
 */
public T fetch() {
      // Just return the value... possible problem since there is no
      // check that curr is in the list
    return curr.getValue();
}

/**
 * Fetches the value at a specific index in the list.
 * @param idx index of the item to return
 * @return the requested item
 */
public T fetch(int idx) {
      // Loop to the right place in the list
    ISLink<T> c=head;
    for(int i=0; i<idx; i++) { c=c.getNext(); }
    curr = c.getNext();
      // Returen the value
    return curr.getValue();
}

/**
 * Advances the <i>current</i> index to the next index, if possible.
 */
public void next() { curr = curr.getNext(); }

/**
 * Advances the <i>current</i> index to the previous index, if possible.
 */
public void prev() {
  curr = curr.getValue - 1;
}

/**
 * Advances the <i>current</i> to the tail element
 */
public void jumpToTail() {
  ISLink<T> c = head;
  while(c.getNext()!=null) {
    i++;
    c = c.getNext();
  }
  curr = c;
}

public ISLink<T> returnTail() {
  jumpToTail();
  return curr;
}

/**
 * Advances the <i>current</i> to the head element
 */
public void jumpToHead() { curr = head.getNext(); }

/**
 * Returns the number of elements in the list
 */
public int size() {
      // I don't keep a size, so the list must be scanned to compute this
    int i=0;
    ISLink<T> c=head;
    while(c.getNext()!=null) { i++; c=c.getNext(); }
    return i;
}

  // Implementation for the links...
class SLink<T> implements ISLink<T> {
    ISLink next;
    T value;

    public SLink() {
          // Empty constructor, everything can be null
    }

    /**
       * Gets the current value for this link cell
       * @return the value
       */
      public T getValue() { return value; }

      /**
       * Sets the current value for this link cell
       * @param v the value to place in this cell
       */
      public void setValue(T v) { value=v; }

      /**
       * Gets the next cell in the list
       * @return the cell
       */
      public ISLink<T> getNext() { return next; }

      /**
       * Sets the next cell in the list
       * @param c the next cell
       */
      public void setNext(ISLink<T> c) {
        next = c;
      }
}

}
