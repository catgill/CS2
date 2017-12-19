

public class Node<N> implements INode<N> {
    N node;

    public Node(N v) {
      node = v;
    }


    public void setValue(N v) {
      node = v;
    }


    public N getValue() {
      return node;
    }
}
