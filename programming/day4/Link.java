

public class Link<T> {
  private T element;        // Value for this node
  private Link<T> next;     // Pointer to next node in list

  Link(T it, Link<T> nextval) {
    element = it;
    next = nextval;
  }
  Link(Link<T> nextval) {
    next = nextval;
  }
  Link<T> next() {        // Return next field
    return next;
  }
  Link<T> setNext(Link<T> nextval) {       // Set next field
    return next = nextval;            // Return element field
  }
  T element() {           // Set element field
    return element;
  } // Set element field
  T setElement(T it) {
    return element = it;
  }
}
