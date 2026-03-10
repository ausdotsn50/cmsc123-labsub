import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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

    // Implement DFS traversal using adjacency matrix
    public void DFSTraversal(String sV) {
        ArrayList<String> visited = new ArrayList<>();
        Stack<String> DFSk = new Stack<>();

        // Using stack instead of queues
        DFSk.push(sV); // Pushing starting vertex to the stack

        // For indexing purposes
        List<String> arrayListOfVertices = Arrays.asList(vertices); 
        int sI = arrayListOfVertices.indexOf(sV); // sI is the index of your letter in the array
        
        // Keep working on the DFS traversal algo until stack is empty
        while(!DFSk.isEmpty()) {
            String v = DFSk.pop();
            sI = arrayListOfVertices.indexOf(v);
            // System.out.println("Peeked:" + v);

            for(int i = numberOfVertices - 1; i >= 0; i--) {
                // If connected and not yet visited
                // Add to the stack
                if(adjacencyMatrix[sI][i] == 1 && !visited.contains(vertices[i])) {
                    DFSk.push(vertices[i]);
                }
            }
            
            // Prevents duplications in adding to the stack
            if(!visited.contains(v)) {
                visited.add(v);
            }

        }
        System.out.println(visited);
    }
}
