

public class Graph<N, W> implements IGraph {

    DoubleLinkList<Node> nodes = new DoubleLinkList<Node>();
    DoubleLinkList<Edge> edges = new DoubleLinkList<Edge>();

    public Graph(Edge<N,W> e) {
      egg = e;
    }
    /**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
    public INode<N>[] getNodeSet(){
      INode<N>[] a = (INode<N>[]) new Node [nodes.size()];
      for (int i = 0; i < nodes.size(); i++) {
        a[i] = nodes.fetch(i);
      }
      return a;
    }

    /**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
    public INode<N>[] getNeighbors(INode<N> n) {
      DoubleLinkList<INode> neighbors = new DoubleLinkList();

      for (int i = 0; i < edges.size(); i++) {
        Edge current = edges.fetch(i);
        if (current.getSource().equals(n)) {
          neighbors.append(current.getDestination());
          }
        if (current.getDestination().equals(n)) {
          neighbors.append(current.getSource());
        }
      }
      INode<N>[] arr = (Node<N>) new Object [neighbors.size()];
      for (int i = 0; i < neighbors.size(); i++) {
        arr[i] = neighbors.fetch(i);
      }
      return arr;
    }


    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
    public INode<N> addNode(N v) {
      N value = v;
      Node<N> new_node = new Node(value);
      boolean duplicate = false;
      if (nodes.size() > 0) {
        for (int i = 0; i < nodes.size(); i++) {
          if (value.equals(nodes.fetch(i).getValue())){
            duplicate = true;
          }
          else {
            duplicate = false;
          }
        }
        if (duplicate == false) {
          nodes.append(new_node);
        }
      }
      else if (nodes.size() == 0) {
        nodes.append(new_node);
      }
      return new_node;
    }

    /**
     * Gets an array of all the edges in the graph
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgeSet() {
      IEdge<N>[] a = (IEdge<N>) new Edge [edges.size()];
      for (int i = 0; i < edges.size(); i++) {
        a[i] = edges.fetch(i);
      }
      return a;
    }

    /**
     * Gets an array of all the edges sourced at a particular node
     * @param n the source node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesFrom(INode<N> n) {
      DoubleLinkList<IEdge> neighbor_from = new DoubleLinkList();

      for (int i = 0; i < edges.size(); i++) {
        Edge current = edges.fetch(i);
        if (current.getSource().equals(n)) {
          neighbor_from.append(current.getDestination());
          }
      }
      INode<N>[] arr_from = (Node<N>) new Object [neighbor_from.size()];
      for (int i = 0; i < neighbor_from.size(); i++) {
        arr_from[i] = neighbor_from.fetch(i);
      }
      return arr_from;
    }

    /**
     * Gets an array of all the edges destined for a particular node
     * @param n the destination node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesTo(INode<N> n) {
      DoubleLinkList<IEdge> neighbor_to = new DoubleLinkList();

      for (int i = 0; i < edges.size(); i++) {
        Edge current = edges.fetch(i);
        if (current.getDestination().equals(n)) {
          neighbor_to.append(current.getSource());
          }
      }
      INode<N>[] arr_to = (Node<N>) new Object [neighbor_to.size()];
      for (int i = 0; i < neighbor_to.size(); i++) {
        arr_to[i] = neighbor_to.fetch(i);
      }
      return arr_to;
    }


    /**
     * Adds an edge to the graph.
     * Duplicate edges are not allowed in the graph. The equals method of the edge can
     * be used to determine if two edges duplicate one another.
     * @param w weight of the edge
     * @param s source node
     * @param d destination node
     */
    public void addEdge(Node<N> s, Node<N> d, W w) {
      Edge egg = Edge(s, d, w);
      boolean dub = false;

      if (edges.size() > 0) {
        for (int i = 0; i < edges.size(); i++) {
          if (egg.getSource().equals(edges.fetch(i).getSource()) && egg.getDestination().equals(edges.fetch(i).getDestination())){
            dub = true;
          }
          else {
            dub = false;
          }
        }
        if (dub == false) {
          edges.append(egg);
        }
      }
      else if (edges.size() == 0) {
        edges.append(egg);
      }
    }
}
