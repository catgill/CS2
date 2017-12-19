

//Taken from chapter 5 of the book


class BSTNode<K, V> {
  private K key; // Key for this node
  private V element; // Element for this node
  private BSTNode<K,V> left; // Pointer to left child
  private BSTNode<K,V> right; // Pointer to right child
  /** Constructors */
  public BSTNode() {
    left = right = null;
  }

  public BSTNode(K k, V val) {
    left = right = null;
    key = k;
    element = val;
  }
  public BSTNode(K k, V val, BSTNode<K,V> l, BSTNode<K,V> r) {
    left = l;
    right = r;
    key = k;
    element = val;
  }

  /** Get and set the key value */
  public K key() {
    return key;
  }

  public void setKey(K k) {
    key = k;
  }

  /** Get and set the element value */
  public V element() {
    return element;
  }

  public void setElement(V v) {
    element = v;
  }
  /** Get and set the left child */
  public BSTNode<K,V> left() {
    return left;
  }

  public void setLeft(BSTNode<K,V> p) {
    left = p;
  }

  /** Get and set the right child */
  public BSTNode<K,V> right() {
    return right;
  }

  public void setRight(BSTNode<K,V> p) {
    right = p;
  }

  /** @return True if a leaf node, false otherwise */
  public boolean isLeaf(){
    return (left == null) && (right == null);
  }
}
