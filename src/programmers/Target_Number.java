package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Target_Number {
    static int[] numbers;
    static int target;
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        for(int number : numbers){
            int size = queue.size();

            for(int i = 0; i<size; i++){
                int current = queue.poll();
                queue.offer(current + number);
                queue.offer(current - number);
            }
        }




    }
}
