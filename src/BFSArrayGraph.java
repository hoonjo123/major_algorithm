import java.util.*;

public class BFSArrayGraph {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;



    public static void main(String[] args) {
        int[][] inputArr = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        int node_n = 5;
        visited = new boolean[node_n];
        adjList = new ArrayList<>();
        for (int i = 0; i < node_n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] a : inputArr) {
            addEdge(a[0], a[1]);
        }
//        for(int i =1; i<=3(높이길이=행의개수)){
        //for(int j=1; j<=5(가로길이-열의개수){
//       1) 시작노드표현식 : (i-1)*5(열의개수) + j
//        2) 타겟의 번호와 타겟의 유효성 체크;
//        2-1) 타겟의 번호 : j에 -1을 빼면 왼쪽, j에서 1더하면 오른쪽 등
//        2-2) 타겟의 유효성 : i와 j가 상하좌우 같이 체크
//        <<상하좌우 체크 로직>>
//        위쪽에 유효성체크
//        if((i-1) >= 1)
//        아래쪽 유효성 체크
//        if((i+1)<=3)
//        왼쪽체크
//        if((j-1)>=1)
//        오른쪽체크
//        if((j+1)<=5)
//        int[] dx = {-1,1,0,0};
//        int[] dy = {0,0,-1,1};
//        int i = 1;
//        int j = 1;
//        for(int d = 0; d<4; d++){
//            int target_i= i+dx[d];
//            int target_j= j+dy[d];
//            if(target_i>=1 && target_i<=3) && target_j>=1 && target_j <=5){
//                addEdge((i-1)*5 + j, (i-1)*5 + (target_j));
//            }
//        }
        distance = new int[node_n]; //최단거리위해 값 초기화
//        Arrays.fill(distance,1); //변수 초기화 하는 또다른 방법
        int shortest = bfs(0, 4);
//        System.out.println(distance[4]); //2 최단거리
        System.out.println(shortest);
    }


    static int bfs(int start,int target) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int next = queue.poll();
//            System.out.print(next + " ");
            for (int johoon : adjList.get(next)) {
                if (!visited[johoon]) {
                    queue.add(johoon);
                    distance[johoon] = distance[next] + 1; //최단거리
                    visited[johoon] = true;

                    if(johoon == target) {
                        return distance[target];
                    }
                }
            }
        }
        return -1;
    }

    static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }

    //최단거리검색 문제의 경우 dfs탐색시 모든노드를 순회하면서 경우에 수에 따라 방문해야하므로 비효율적
    //bfs탐색시 1차례만 모든 노드 방문시에 최단 거리 알 수 있음
}
