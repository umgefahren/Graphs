public class FloydWarshall extends Graph {

    FloydWarshall(int vertices, Integer[][] weightMatrix) {
        super(vertices, weightMatrix);
    }

    public static FloydWarshall readFromFile(String path, int vertices) {
        Integer[][] matrix = Graph.readFromFileToMatrix(path, vertices);
        return new FloydWarshall(vertices, matrix);
    }

    public Integer[][] runFloydWarshall() {
        Integer[][] dist = new Integer[vertices][vertices];
        Graph.fillWith(dist, Integer.MAX_VALUE / 2);

        for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                Integer element = this.weightMatrix[i][j];
                if (element != null) {
                    dist[i][j] = element;
                }

            }
        }

        for (int k = 0; k < this.vertices; k++) {
            for (int i = 0; i < this.vertices; i++) {
                for (int j = 0; j < this.vertices; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

}
