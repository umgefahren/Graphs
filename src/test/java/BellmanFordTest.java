import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordTest {
    public static Integer[] cleanLine(Integer[] line) {
        Integer[] ret = line.clone();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = ret[i] == null ? 0 : ret[i];
        }
        return ret;
    }

    @Test
    void runBellmanFord() {
        BellmanFord graph = BellmanFord.readFromFile("data.dat", 10);
        Integer[][] matrix = Graph.readFromFileToMatrix("data_distance_matrix.dat", 10);
        Graph.GraphAlgorithmResult result = graph.runBellmanFord(5);
        Integer[] line = matrix[5];
        line = cleanLine(line);
        assertArrayEquals(line, result.distance);
    }
}