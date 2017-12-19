import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    IGraph<N, W> g;
    IEdge<N,W> e;

    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
        g = null;
        e = null;
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        // Open the file
        Graph r = new Graph;
        INode n = r.nodeMaker(value);
        INode s = new Node;
        INode d = new Node;
        double w;



        BufferedReader br = new BufferedReader(new FileReader(filename));
        String st;
        char col;
        while ((st = br.readLine()) != null) {
          String[] var = s.split(":");
          s = (V) var[0];
          d = (V) var[1];
          w = (double) var[2];
          r.addNode(s);
          r.addNode(d);
          r.addEdge(s, d, w);

        }

        // Parse the lines. If a line does not have exactly 3 fields, ignore the line
        // For each line, add the nodes and edge
          //How many feilds and what is in each fields
          //After i have the right fields, need make nodes, weights, and add to graphs
          //...making nodes could be tricky... Could get multiple nodes with the same value

        // Return the graph instance
        return r;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}
