import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFSArrayGraph {
    static boolean[] visited;
    static int[][] static_graph;
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };
        static_graph = graph;
        visited = new boolean[graph.length]; //초기화는 false
        dfs(0);
        //0,1,3,2,4
    }
    static void dfs(int start){
        visited[start] = true;
        System.out.print(start);
        for(int i = 0; i< static_graph[start].length; i++) {
            if (visited[i] == false && static_graph[start][i] == 1) {
                dfs(i);
            }
        }
    }
}
