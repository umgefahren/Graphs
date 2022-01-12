import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DijkstraTest {
    @Test
    void runDijkstra() {
        Dijkstra graph = Dijkstra.readFromFile("data.dat", 10);
        Integer[][] matrix = Graph.readFromFileToMatrix("data_distance_matrix.dat", 10);
        Graph.GraphAlgorithmResult result = graph.runDijkstra(5);
        Integer[] line = matrix[5];
        line = Graph.cleanLine(line);
        assertArrayEquals(line, result.distance);
    }
}
