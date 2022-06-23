package Graph;

import java.util.LinkedList;

public class GraphEx {
    int vertices;
    int[][] matrix;

    GraphEx(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = weight;
        matrix[destination][source] = weight;

    }

    public void printMatrix() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void dijkstra(int source, int destination) {
        int distance[] = new int[vertices];
        int prevpath[] = new int[vertices];
        boolean visited[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }
        distance[source] = 0;

        for(int i=0; i<vertices; i++){
            int u=findminimumvertex(visited, distance);
        }
    }

    public int findminimumvertex(boolean visited[], int distance[]) {
        int minvertex=-1;
        for(int i=0; i<vertices; i++){
            if(minvertex==-1 && !visited[i]){
                minvertex=i;

            }
        }
        return minvertex;
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to ");
            for (int j = 0; j < vertices; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println("");
        }

    }

    public LinkedList getAdjNode(int i) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int j = 0; j < vertices; j++) {
            if (matrix[i][j] == 1) {
                list.add(j);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        GraphEx g = new GraphEx(5);
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(0, 5, 100);
        g.addEdge(1, 3, 20);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 15);
        g.addEdge(3, 4, 5);
        g.addEdge(3, 5, 20);
        g.addEdge(4, 5, 15);
        g.printMatrix();
        g.printGraph();
        g.getAdjNode(0);
    }
}
