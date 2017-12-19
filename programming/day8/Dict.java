

public class Dict<K extends Comparable<K>,V> implements IDict, DoubleLinkList {

  int size;
  DoubleLinkList stuff = new DoubleLinkList();
//  int removed;
//  IDict<K> x;

  public Dict() {
    size = 0;
    stuff = null;
  }

  /**
   * Adds a value to the dictionary, replacing the existing value if any.
   * @param k key for the new value
   * @param v value
   * @return the value replaced, otherwise null
   */
  public V add(K k, V v) {
    V hold;
    for (int i = 0; i < size(); i++) {
      if (k.equals(stuff.getValue(i))) {
        hold = stuff.getValue(i);
        stuff.insert(k, v);
        return hold;
      }
      else {
        stuff.append(v);
        return null;
      }
    }

  }

  /**
   * Removes a value and key from the dictionary. An unmatched key should return null.
   * @param k key to remove
   * @return the value of the removed key
   */
  public V remove(K k) {
    V hold;
    for (i = 0; i < size(); i++) {
      if (k.equals(stuff[i])) {
         hold = stuff[i];
        stuff.remove(k);
        return hold;
      }
      else {
        return null;
      }
    }
  }

  /**
   * Returns the size of the dictionary
   * @return the number of values stored in the dictionary
   */
  public int size() {
    size = stuff.size();
    return size;
  }

  /**
   * Returns the value associated with a particular key in the dictionary.
   * Returns null if there is no matching key.
   * @param k key to retrieve the value for
   * @return the value
   */
  public V fetch(K k) {
    V fetched;
    fetched = (V) stuff.fetch(k);
    return fetched;
  }

  /**
   * Returns an array of the keys in the dictionary
   * @return array of all keys
   */
  public K[] keys() {
    K[] keys = new K[stuff.size()];
    for (int i = 0; i < size(); i++) {
      keys[i] = (K) stuff.getValue(i);
    }
    return keys;
  }
}
