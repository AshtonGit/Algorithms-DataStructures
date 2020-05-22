/*
 *
 * V = number of vertices/ nodes
 * 1. Create an array to track which nodes have been visited.
 *    Init all values to false.
 *    boolean[] visited = new boolean[V]
 *
 * 2. Create an array to track the current minDistance to each node.
 *    Init all values to infinity
 *    distance = int[V]
 *
 * 3.  Set source nodes minDistance to 0 so that it is first node visited by algorithm
 *     distance[source] = 0
 *
 * 4.  start a loop that iterates for V-1 times.
 *     for(int i=0; i<V-1; i++)
 *
 * 5.  calculate which unvisited node is closest.
 *     int min = infinity
 *     iterate through all nodes, if node is univisited and distance to node <= min then
 *     min = dist[node], minNode = node
 *     return node
 *
 *     int u = minDistance(distance, visited)
 *
 * 6.  mark node U as visited
 *     visited[u] = true
 *
 * 7. Now that U has been visited it's edges to other nodes have been revealed. Update the distance array.
 *    Iterate through all nodes V
 *   IF these 4 conditions are met
 *   i.Node hasn't already been visited:
 *          !visited[v]
 *   ii. Aren't getting distance of node to itself:
 *          graph[U][v] != 0
 *  iii. An edge exists between node and v:
 *          graph[U][v] != Integer.MAX_VALUE
 *  iv. The path including node to V is smaller than current best path to that V:
 *          dist[U] + graph[U][V] < dist[V]
 *
 *  Then update the current best path to node V
 *   dist[V] = dist[U] + graph[U][V]
 */

public class Djikstra {

    private static int minDistance(int[] distance, boolean[] visited){
        int n = distance.length;
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(!visited[i] && distance[i] <= min){
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;

    }

    public static int[] dijkstra(int[][] graph, int src){
        int V = graph.length;
        int[] distance = new int[V];
        int[] path = new int[V];
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            distance[i]=Integer.MAX_VALUE;
            visited[i]=false;
            path[i] = -1;
        }

        distance[src]=0;
        path[src] = src;
        for(int i =0; i<V-1; i++){
            int u = minDistance(distance, visited);
            visited[u] = true;

            for(int v =0; v<V; v++){
                if(!visited[v] && graph[u][v] !=0 && distance[u]!= Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]){
                    distance[v] = distance[u]+graph[u][v];
                    path[v] = u;
                }
            }
        }

        return path;
    }

}
