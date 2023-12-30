package programmers;
import java.util.*;

public class Game_map {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(bfs(maps));
    }
    private static int bfs(int[][] maps){
        int rows = maps.length;
        int cols = maps[0].length;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if(x ==rows -1 && y == cols -1){
                return distance;

            }

            for( int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isValid(nx,ny,rows,cols) && maps[nx][ny] == 1 && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny, distance + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
    private static boolean isValid(int x, int y, int rows, int cols){
        return  x >= 0 && x<rows && y>=0 && y<cols;
    }
}



