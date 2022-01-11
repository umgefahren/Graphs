public class Graphs {
    public static void main(String[] args) {
        FloydWarshall graph = FloydWarshall.readFromFile("data.dat", 10);
        System.out.println(graph);
    }
}
