import java.util.*;

public class Main {
    public static void main(String[] args) {
        // sliding window problem
        Random rand = new Random();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(rand.nextInt(0,20));
        }
        System.out.println(arr);
        buySell(arr);
    }

    public static void buySell(List<Integer> x){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int buyLocation = 0, sellLocation = 0;
        for (int i = 0; i < x.size(); i++) {
            if(x.get(i) < minPrice){
                minPrice = x.get(i);
                buyLocation = i;
            }
            else if(x.get(i) - minPrice > maxProfit){
                maxProfit = x.get(i) - minPrice;
                sellLocation = i;
            }
        }

        System.out.println("Max Profit = " + maxProfit + " // bought at [" + (buyLocation+1) + "] sold at [" + (sellLocation+1) + "]");
    }
}