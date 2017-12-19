/**
 * Interface for an edge in a graph. Edges are immutable.
 */
public class Edge<N,W> implements IEdge {

    public IEdge<N,W> egg;
    public INode<N> source;
    public INode<N> dest;
    public W weight;

    public Edge(INode<N> s, INode<N> d, W w) {
      source = s;
      dest = d;
      weight = w;
    }


    public INode<N> getSource() {
      return source;
    }


    public INode<N> getDestination() {
      return dest;
    }


    public W getWeight() {
      return weight;
    }


    public boolean equals(Object o) {
      IEdge<N,W> obj = (Edge<N,W>) o;
      if (egg.getSource().equals(obj.getSource()) && egg.getDestination().equals(obj.getDestination())) {
        return true;
      }
      else {
        return false;
      }
    }
}
