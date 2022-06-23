package Graph;

import Graph.LinkedList.Node;

public class GraphAdjList {

    LinkedList[] a;
    int vertices;

    GraphAdjList(int vertices) {
        a = new LinkedList[vertices];
        this.vertices = vertices;

        for (int i = 0; i < vertices; i++) {
            a[i] = new LinkedList();

        }
    }

    public void addEdge(int source, int destination) {
        a[source].addNode(destination);
        a[destination].addNode(source);

    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " is connected to: ");
            for (int j = 0; j < a[i].getSize(); j++) {
                System.out.print(a[i].getDataAtAnyPos(j) + " , ");
            }

            System.out.println();
        }

    }

    public void printGraph1() {
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " is connected to ");
            Node current = a[i].head;
            while (current != null) {
                System.out.print(current.data + " ,");
                current = current.next;
            }
            System.out.println(" ");
        }
    }

    public void BFS(int rootnode) {
        boolean visited[] = new boolean[vertices];
        QueueExample queue = new QueueExample(vertices);
        visited[rootnode] = true;
        queue.enqueue(rootnode);
        while (!queue.isEmpty()) {
            int x = queue.dequeue();
            int adjlist[] = getAdjNode(x);
            for (int i = 0; i < adjlist.length; i++) {
                int adjval = adjlist[i];
                if (!visited[adjval]) {
                    queue.enqueue(adjval);
                    visited[adjval] = true;
                }
            }
            System.out.println(x);

        }
        // dfs

    }

    public void depthFirstSearch(int rootnode) {
        boolean visited[] = new boolean[vertices];
        visited[rootnode] = true;
        dfs(rootnode, visited);

    }

    public void dfs(int rootnode, boolean visited[]) {
        System.out.println(rootnode);
        int[] list = getAdjNode(rootnode);
        for (int i = 0; i < list.length; i++) {
            int adjval = list[i];
            if (!visited[adjval]) {
                visited[adjval] = true;
                dfs(adjval, visited);
            }
        }
    }

    public int[] getAdjNode(int i) {
        int[] list = new int[a[i].getSize()];
        int indx = 0;
        Node current = a[i].head;
        while (current != null) {
            list[indx++] = current.data;
            current = current.next;
        }

        return list;

    }

    public void topoSort() {
        int indegree[] = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            int[] list = getAdjNode(i);
            for (int j = 0; j < list.length; j++) {
                int adjval = list[j];
                indegree[adjval]++;
            }

        }
        QueueExample queue = new QueueExample(vertices);
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.enqueue(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int x = queue.dequeue();
            System.out.println(x);
            int[] list = getAdjNode(x);
            for (int i = 0; i < list.length; i++) {
                int adjval = list[i];
                indegree[adjval]--;
                if (indegree[adjval] == 0) {
                    queue.enqueue(adjval);
                }
            }
        }
        if (count != vertices) {
            System.out.println("Not a topological sort");
        }

    }

    public static void main(String[] args) {
        GraphAdjList g = new GraphAdjList(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.printGraph();
        g.printGraph1();
    }

}