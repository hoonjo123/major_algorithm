public class TeamTest01 {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] result = solution(sequence, k);

        System.out.println(result[0]+ "," + result[1]);
    }

    public static int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int size = sequence.length;
        int and1 = 0;
        int and2 = 0;

        for (right = 0; right < sequence.length; right++) {
            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (size > right - left) {
                    size = right - left;
                    and1 = left;
                    and2 = right;
                }
            }
        }

        return new int[]{and1, and2};
    }
}
