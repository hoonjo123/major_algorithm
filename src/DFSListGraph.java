import java.util.ArrayList;
import java.util.List;

public class DFSListGraph {
    static List<List<Integer>> addList;
    static boolean[] visited;
    public static void main(String[] args) {
        //node 번호가 단방향으로 주어졌을 때 양방향으로 표현
        /*
        myList.get(0).add(1)
        myList.get(0).add(2)
        myList.get(1).add(3)
        ...
        for(int i= 0; i<n <= n은 전체 노드의 개수; i++){
            myList.add(new ArrayList);
        이중 List를 만들어서 담기*/

        int[][] inputArr = {{0,1},{0,2},{1,3},{2,3},{2,4}};
        int node_n = 5;
        visited = new boolean[node_n]; //노드의 개수만큼 초기화
        addList = new ArrayList<>();
        for(int i = 0; i<node_n; i++){
            addList.add(new ArrayList<>());
        }
        for(int[] a : inputArr){
            addEdge(a[0],a[1]);
        }
        for(int i = 0; i< node_n; i++){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
    static void addEdge(int a, int b){
        addList.get(a).add(b);
        addList.get(b).add(a);
    }
    static void dfs(int start){
        visited[start] = true;
        System.out.println(start);
        for(int a : addList.get(start)){
            if(!visited[a]){
                dfs(a);
            }
        }

    }
}


//프로그래머스 네트워크
