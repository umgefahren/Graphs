import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloydWarshallTest {

    @Test
    void runFloydWarshall() {
        FloydWarshall graph = FloydWarshall.readFromFile("data.dat", 10);
        Integer[][] matrix = Graph.readFromFileToMatrix("data_distance_matrix.dat", 10);
        Integer[][] floydResult = graph.runFloydWarshall();
        Graph.cleanMatrix(floydResult);
        assertArrayEquals(floydResult, matrix);
    }
}