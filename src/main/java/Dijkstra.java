import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstra extends Graph {

    private static class Node implements Comparable<Node> {
        final int index;
        int distance;

        private Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            Integer this_distance = this.distance;
            Integer o_distance = o.distance;
            return this_distance.compareTo(o_distance);
        }
    }

    Dijkstra(int vertices, Integer[][] weightMatrix) {
        super(vertices, weightMatrix);
    }

    public static Dijkstra readFromFile(String path, int vertices) {
        Integer[][] matrix = Graph.readFromFileToMatrix(path, vertices);
        return new Dijkstra(vertices, matrix);
    }

    public GraphAlgorithmResult runDijkstra(int start) {
        PriorityQueue<Node> distance = new PriorityQueue<>();
        Integer[] ret = new Integer[vertices];
        Integer[] pre = new Integer[vertices];

        for (int i = 0; i < this.vertices; i++) {
            int nodeDistance = Integer.MAX_VALUE / 2;
            if (i == start) {
                nodeDistance = 0;
            }
            Node node = new Node(i, nodeDistance);
            distance.add(node);
            ret[i] = nodeDistance;

        }

        while (!distance.isEmpty()) {
            Node u = distance.poll();
            ArrayList<Node> addAgain = new ArrayList<>();

            while (!distance.isEmpty()) {
                Node v = distance.poll();
                Integer weight = weightMatrix[u.index][v.index];

                if (weight != null) {
                    int alt = u.distance + weight;
                    if (alt < v.distance) {
                        v.distance = alt;
                        ret[v.index] = alt;
                        pre[v.index] = u.index;
                    }
                }
                addAgain.add(v);
            }
            distance.addAll(addAgain);
        }
        return new GraphAlgorithmResult(ret, pre);
    }
}
