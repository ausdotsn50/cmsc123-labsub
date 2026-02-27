import java.util.Scanner;

/*
    Laboratory Exercise on Graphs
    Description:
        - This laboratory demonstrates how to perform BFS traversal on a pre-defined adj matrix of a graph
    Submitted by: Angela Denise Almazan
*/
public class Main {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        Graph g = new Graph();
        System.out.println("Choose from these vertices: ");
        g.showAllVertices();
        System.out.println();

        System.out.print("Starting Vertex: ");
        String sV = scn.nextLine();

        g.BFSTraversal(sV);
        scn.close();
   }   
}
