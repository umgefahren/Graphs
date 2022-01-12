import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Graph {
    public static class GraphAlgorithmResult {
        Integer[] distance;
        Integer[] predecessor;

        GraphAlgorithmResult(Integer[] distance, Integer[] predecessor) {
            this.distance = distance;
            this.predecessor = predecessor;
        }
    }

    public static Integer[] cleanLine(Integer[] line) {
        Integer[] ret = line.clone();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = ret[i] == null ? 0 : ret[i];
        }
        return ret;
    }

    int vertices;
    Integer[][] weightMatrix;

    Graph(int vertices, Integer[][] weightMatrix) {
        this.vertices = vertices;
        this.weightMatrix = weightMatrix;
    }


    public static Integer[][] readFromFileToMatrix(String path, int vertices) {
        Integer[][] matrix = new Integer[vertices][vertices];
        try {
            File p = new File(path);
            Scanner myReader = new Scanner(p);
            int y = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Scanner lineReader = new Scanner(data);
                int x = 0;
                while (lineReader.hasNextInt()) {
                    int num = lineReader.nextInt();
                    matrix[y][x] = num == 0 ? null : num;
                    x += 1;
                }
                y += 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // Graph ret = new Graph(vertices, matrix);
        return matrix;
    }

    public static Graph readFromFile(String path, int vertices) {
        Integer[][] matrix = Graph.readFromFileToMatrix(path, vertices);
        return new Graph(vertices, matrix);
    }

    @Override
    public String toString() {
        return Graph.printMatrix(this.weightMatrix);
    }

    public static String printMatrix(Integer[][] matrix) {
        String ret = "";
        for (Integer[] line : matrix) {
            for (Integer element : line) {
                if (element == null) {
                    ret = ret.concat("--");
                    // System.out.print("--");
                } else if (element == Integer.MAX_VALUE) {
                    ret = ret.concat("∞∞");
                    // System.out.print("∞∞");
                } else {
                    ret = ret.concat(String.format("%02d", element));
                    // System.out.print(String.format("%02d", element));
                }
                ret = ret.concat(" ");
                // System.out.print(" ");
            }
            ret = ret.concat("\n");
            // System.out.println();
        }
        return ret;
    }

    public static void cleanMatrix(Integer[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            matrix[i][i] = null;
        }
    }

    public static void fillWith(Integer[][] matrix, Integer number) {
        for (int i = 0; i < matrix.length; i++) {
            Integer[] integers = matrix[i];
            for (int j = 0; j < integers.length; j++) {
                matrix[i][j] = number;
            }
        }
    }
}
