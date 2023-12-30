import java.util.HashMap;
import java.util.Map;

public class Greedy {
    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        int amount = 99;

        Map<Integer,Integer> result = minCoins(coins, amount);

        System.out.println(result);
        System.out.println(result.size());
    }

     static Map<Integer,Integer> minCoins(int[] coins, int amount) {
        Map<Integer,Integer> coinCountMap = new HashMap<>();


        for(int i = coins.length -1; i>=0; i--){
            int coinCount = amount/coins[i];
            coinCountMap.put(coins[i], coinCount);
            amount -= coinCount * coins[i];
        }
        return coinCountMap;
    }
}
