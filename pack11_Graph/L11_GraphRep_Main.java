package pack11_Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class L11_GraphRep_Main {
    public static void main(String[] args) {
        q3();
    }

    final static int inf = Integer.MAX_VALUE;

    static void q2() {
        // A B C D E
        int[][] thisGraph = { { 0, 3, inf, inf, 2 }, // your 1.1
                { 3, 0, 1, inf, inf },
                { inf, 1, 0, 4, inf },
                { inf, inf, 4, 0, 5 },
                { 2, inf, inf, 5, 0 } };
        System.out.println("computing dfs");
        q2_dfs(thisGraph);
    }

    private static void q2_dfs(int[][] thisGraph) {
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        stack.add(0); // root is at A, we'll suffix next city
        while (notEmpty(stack)) {
            int parent = stack.remove(stack.size() - 1); // pop()
            visited.add(parent);
            for (int x = 0; x < thisGraph.length; x++) {
                if (0 < thisGraph[parent][x] && thisGraph[parent][x] < inf && !visited.contains(x)) {
                    stack.add(x);
                    visited.add(x);
                    System.out.println("Edge " + parent + ", " + x);
                }
            } // for
        }
    }

    private static boolean notEmpty(ArrayList<Integer> stack) {
        return !stack.isEmpty();
    }

    // A B C D E F
    static int[][] distanceBetween = { { 0, 4, 5, inf, inf, inf },
                                        { 4, 0, 11, 9, 7, inf },
                                        { 5, 11, 0, inf, 3, inf },
                                        { inf, 9, inf, 0, 13, 2 },
                                        { inf, 7, 3, 13, 0, 6 },
                                        { inf, inf, inf, 2, 6, 0 } };

    static void q3() {
        int A, B, C, D, E, F;
        A = 0;
        B = 1;
        C = 2;
        D = 3;
        E = 4;
        F = 5;
        System.out.println("dijkstra from A");
        dijkstra(distanceBetween, A);
    }

    static void dijkstra(int[][] graph, int source) {
        int[] distance = initialize_distance_from_source(graph.length, source);
        // int[] prev = new int[distance.length];
        boolean[] visited = new boolean[graph.length];
    
        while (moreCityToExplore(visited)) {
            int exploring = nextExplore(visited, distance);
            boolean neighbor_of_exploring = false;
            for (int x = 0; x < distance.length; x++) {
                neighbor_of_exploring = 0 < distanceBetween[exploring][x] && distanceBetween[exploring][x] < inf;
                if (neighbor_of_exploring) {
                    if (distance[x] > distance[exploring] + graph[exploring][x]) {
                        distance[x] = distance[exploring] + graph[exploring][x];
                        // prev[x] = exploring;
                    }
                }
            }
    
            visited[exploring] = true;
            System.out.println("exploring " + exploring + " " + Arrays.toString(distance));
        }
        // System.out.println("prev " + Arrays.toString(prev));
    }
    
    private static int[] initialize_distance_from_source(int numCities, int source) {
        int[] distance = new int[numCities];
        for (int i = 0; i < numCities; i++)
            distance[i] = (source == i) ? 0 : inf; 
        // start from source!!
        return distance;
    }

    private static boolean moreCityToExplore(boolean[] visited) {
        for (int i = 0; i < visited.length; i++)
            if (!visited[i]) {
                return true;
            }
        return false;
    }

    private static int nextExplore(boolean[] visited, int[] dist) {
        int city_index = -1;
        int minDistance = Integer.MAX_VALUE; 
    
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < minDistance) {
                minDistance = dist[i];
                city_index = i;
            }
        }
        return city_index;
    }    
}
