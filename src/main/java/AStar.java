public class AStar {


    private static int minDistance(int[] distance, int[] heuristic, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int n = distance.length;
        for(int i=0; i<n; i++){
            if(distance[i] != Integer.MAX_VALUE && distance[i] + heuristic[i] <= min && !visited[i]){
                min = distance[i] + heuristic[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static int[] Astar(int[][] graph, int[] heuristic, int src){
        int n = graph.length;
        int[] path= new int[n]; // for value at path[x] is parent of x. So path[0] = 3 means Node 3 is parent of Node 0.
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];

        for(int i =0; i<n; i++){
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
            path[i] = -1;
        }

        distance[src]= 0;
        path[src] = src;


        for(int i =0; i<n-1; i++){
            int u = minDistance(distance, heuristic, visited);
            visited[u] = true;
            if(heuristic[u]==0)return path;
            for(int v = 0; v<n; v++){
                if(!visited[v] && graph[u][v]!=0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]){
                    distance[v] = distance[u] + graph[u][v];
                    path[v] = u;                     // reached the destination node
                }
            }
        }
        return path;
    }

}
