import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class Graph {
    private int[][] adjacencyMatrix;
    private String[] vertices;
    private int numberOfVertices;

    public Graph() {
        numberOfVertices = 6;

        vertices = new String[]{"A", "B", "C", "D", "E", "F"};

        adjacencyMatrix = new int[][]{
                {0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 0, 1, 1, 0}
        };
    }

    public void showAllVertices() {
        for(int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i] + " ");
        }
    }

    // Implement BFS traversal using adjacency matrix
    public void BFSTraversal(String sV) {
        Queue<String> visited = new LinkedList<>();
        Queue<String> BFSq = new LinkedList<>();
        BFSq.add(sV); // Starting vertex

        List<String> arrayListOfVertices = Arrays.asList(vertices); // indexing purposes
        int sI = arrayListOfVertices.indexOf(sV);

        // After this, you're done visiting all adj of chosen vertex
        while(!BFSq.isEmpty()) {
            String v = BFSq.poll();
            sI = arrayListOfVertices.indexOf(v);
            
            for(int i = 0; i < numberOfVertices; i++) {
                if(adjacencyMatrix[sI][i] == 1 && !visited.contains(vertices[i])) {
                    // System.out.print(i);
                    // System.out.println("Connected at: " + vertices[i]);
                    BFSq.add(vertices[i]);
                }
            }
            
            if(!visited.contains(v)) {
                visited.add(v);
            }
        }

        System.out.println(visited);
    }  
}
