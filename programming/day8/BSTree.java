//Modelled after the BST code in chapter 5

public class BSTree<K extends Comparable<K>,V> implements IDict {

  private BSTNode<K,V> root;
  private int nodecount;


  BSTree() {
    root = null;
    nodecount = 0;
  }


  public void add(K k, V v) {
  root = inserthelp(root, k, v);
  nodecount++;
  }


  public V remove(K k) {
    V temp = findhelp(root, k); // First find it
    if (temp != null) {
      root = removehelp(root, k); // Now remove it
      nodecount--;
    }
    return temp;
  }


  public V fetch(K k) {
    return findhelp(root, k);
  }


  public int size() {
    return nodecount;
  }

  public K[] keys() {
    K[] arr = new K[size];
    for (int i = 0; i < size; i++) {
      arr[i] =
    }
  }


  private BSTNode<K,V> inserthelp(BSTNode<K,V> rt, K k, V v) {
    if (rt == null) {
      BSTNode<K,V> n = new BSTNode<K,V>(k, v);
      arr.append(n);
      return n;
    }
    if (rt.key().compareTo(k) > 0) {
      rt.setLeft(inserthelp(rt.left(), k, v));
      arr.append(rt);
    }
    else {
      rt.setRight(inserthelp(rt.right(), k, v));
      arr.append(rt);
    }
    return rt;
  }

  private V findhelp(BSTNode<K,V> rt, K k) {
  if (rt == null) {
      return null;
  }
  if (rt.key().compareTo(k) > 0) {
    return findhelp(rt.left(), k);
  }
  else if (rt.key().compareTo(k) == 0) {
    return rt.element();
  }
  else {
    return findhelp(rt.right(), k);
  }
}


private BSTNode<K,V> removehelp(BSTNode<K,V> rt,K k) {
  if (rt == null) {
    return null;
  }
  if (rt.key().compareTo(k) > 0) {
    rt.setLeft(removehelp(rt.left(), k));
  }
  else if (rt.key().compareTo(k) < 0) {
    rt.setRight(removehelp(rt.right(), k));
  }
  else {
    if (rt.left() == null) {
      return rt.right();
    }
    else if (rt.right() == null) {
      return rt.left();
    }
  }
  return rt;
}
}
