public class BellmanFord extends Graph {
    BellmanFord(int vertices, Integer[][] weightMatrix) {
        super(vertices, weightMatrix);
    }

    public static BellmanFord readFromFile(String path, int vertices) {
        Integer[][] matrix = Graph.readFromFileToMatrix(path, vertices);
        return new BellmanFord(vertices, matrix);
    }

    public GraphAlgorithmResult runBellmanFord(int start) {
        Integer[] distance = new Integer[vertices];
        Integer[] predecessor = new Integer[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE / 2;
            predecessor[i] = null;
        }

        distance[start] = 0;

        for (int u = 0; u < vertices; u++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    Integer element = weightMatrix[i][j];
                    if (element == null) {
                        continue;
                    }
                    if (distance[i] + element < distance[j]) {
                        distance[j] = distance[i] + element;
                        predecessor[j] = i;
                    }
                }
            }
        }

        for (int u = 0; u < vertices; u++) {
            for (int v = 0; v < vertices; v++) {
                Integer element = weightMatrix[u][v];
                if (element == null) {
                    continue;
                }
                if (distance[u] + weightMatrix[u][v] < distance[v]) {
                    return null;
                }
            }
        }

        return new GraphAlgorithmResult(distance, predecessor);
    }
}
