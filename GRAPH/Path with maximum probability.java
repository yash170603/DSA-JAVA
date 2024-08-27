import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int source, int destination) {
        // Create the adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        int index = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Pair(v, succProb[index]));
            adj.get(v).add(new Pair(u, succProb[index]));  // Include bidirectional edges
            index++;
        }

        // Probability array initialized with 0.0
        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[source] = 1.0;

        // Priority queue to store (node, probability) pairs, ordered by probability
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.pb, a.pb));
        pq.offer(new Pair(source, 1.0));

        while (!pq.isEmpty()) {
            Pair parent = pq.poll();
            int node = parent.dest;
            double probab = parent.pb;

            // Explore all neighbors of the current node
            for (Pair child : adj.get(node)) {
                int newNode = child.dest;
                double dist_prob = child.pb;

                // If the new path has a higher probability, update and push to the queue
                if (probab * dist_prob > prob[newNode]) {
                    prob[newNode] = probab * dist_prob;
                    pq.offer(new Pair(newNode, prob[newNode]));
                }
            }
        }

        // If destination is unreachable, return 0.0
        return prob[destination] == 0.0 ? 0.0 : prob[destination];
    }
}

class Pair {
    int dest;
    double pb;

    Pair(int dest, double pb) {
        this.dest = dest;
        this.pb = pb;
    }
}
