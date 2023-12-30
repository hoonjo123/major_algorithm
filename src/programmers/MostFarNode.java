package programmers;

import java.util.*;

public class MostFarNode {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = solution(n, edge);
        System.out.println(result);

    }

    public static int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distances[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (distances[next] == -1) {
                    distances[next] = distances[current] + 1;
                    queue.add(next);
                }
            }
        }

        int maxDistance = Arrays.stream(distances).max().getAsInt();
        int answer = (int) Arrays.stream(distances).filter(d -> d == maxDistance).count();

        return answer;
    }
}
