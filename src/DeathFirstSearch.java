import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeathFirstSearch {
    static class Node {
        char data;
        public Node(char data) {
            this.data = data;
        }
    }
    static class Graph {

        ArrayList<Node> nodes;
        int[][] matrix;

        Graph(int size){
            nodes = new ArrayList<>();
            matrix = new int[size][size];
        }
        public void addNode(Node node) {
            nodes.add(node);
        }
        public void addEdge(int src, int dst) {
            matrix[src][dst] = 1;
        }
        public boolean checkEdge(int src, int dst) {
            if(matrix[src][dst] == 1) {
                return true;
            }
            else {
                return false;
            }
        }
        public void print() {

            System.out.print("  ");
            for(Node node : nodes) {
                System.out.print(node.data + " ");
            }
            System.out.println();

            for(int i = 0; i < matrix.length; i++) {
                System.out.print(nodes.get(i).data + " ");
                for(int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        public void breadthFirstSearch(int src) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[matrix.length];

            queue.offer(src);
            visited[src] = true;

            while(queue.size() != 0) {

                src = queue.poll();
                System.out.println(nodes.get(src).data + " = visited");

                for(int i = 0; i < matrix[src].length; i++) {
                    if(matrix[src][i] == 1 && !visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(N);
        ArrayList<Integer> gateways = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            addEdge(adj, N1, N2);
        }
        for (int i = 0; i < E; i++) {
            gateways.add(in.nextInt()); // the index of a gateway node
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Bobnet agent is positioned this turn
            Integer closestExit = 0;
            Integer closestExitDistance = Integer.MAX_VALUE;
            for(Integer i : gateways) {
                if(Integer.valueOf(getShortestPath(adj, SI, i, N).charAt(0)) < closestExitDistance) {
                    closestExitDistance = Integer.valueOf(getShortestPath(adj, SI, i, N).charAt(0));
                    closestExit = i;
                    String shortestPath = getShortestPath(adj, SI, closestExit, N);
                    System.out.println(shortestPath);
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int i , int j) {
        adj.get(i).add(j);
        adj.get(i).add(j);
    }
    static String getShortestPath(ArrayList<ArrayList<Integer>> adj, int s, int dest, int v) {
        int pred[] = new int[v];
        int dist[] = new int[v];

        if (BFS(adj, s, dest, v, pred, dist) == false) {
            return "0";
        }

        LinkedList<Integer> path = new LinkedList<>();
        int crawl = dest;
        path.add(crawl);
        while(pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }
        String str = "";
        str += dist[dest] + " ";
        for(int i = path.size() -1; i >= 0; i--) {
            str += path.get(i) + " ";
        }

        return str;
    }
    static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        for(int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        while(!queue.isEmpty()) {
            int u = queue.remove();
            for(int i = 0; i < adj.get(u).size(); i++) {
                if(visited[adj.get(u).get(i)] == false) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    queue.add(adj.get(u).get(i));

                    if(adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
