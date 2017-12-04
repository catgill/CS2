/**
 * Class to test timing difference between Ring and Array Queues
 */
public class Test {
    static int qsize=10000;
    
    /**
     * Generates an ArrayQueue and a RingQueue
     */
    public static void main(String[] argv) {
        IQueue<Integer> aq = new ArrayQueue<Integer>(qsize);
        IQueue<Integer> rq = new RingQueue<Integer>(qsize);
        
        System.out.print("ArrayQueue: ");
        runTest(aq);
        System.out.print("RingQueue: ");
        runTest(rq);
        System.out.print("RingQueue: ");
        runTest(rq);
        System.out.print("ArrayQueue: ");
        runTest(aq);
        
    }
    
    /**
     * Repeatedly fill and empty the passed in Queue
     */
    public static void runTest(IQueue<Integer> q) {
        long s;
        long e;
        
        try {
        // The test enqueues and dequeues full queue 20 times
        s = System.currentTimeMillis();
        for(int j=0; j<20; j++) {
            for(int i=0; i<qsize; i++) {
                q.enqueue(i);
            }
            for(int i=0; i<qsize; i++) {
                q.dequeue();
            }
        }
        e = System.currentTimeMillis();
        System.out.println("run completed in approx "+(e-s)+" ms");
        } catch (OverFlowException err) {
            System.err.println("Error in queue implementation - OverFlowException");
        } catch (UnderFlowException err) {
            System.err.println("Error in queue implementation - UnderFlowException");
        }
        
    }
}
