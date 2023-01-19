import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("GrazieInspection")
public class Main {
    public static void main(String[] args) {
        // buy sell stock once for maximum profit
        // take in start position
            // start position = buy price
        // Search through array following start position
        // return highest value after start position - start position value
            // highest - start = profit
            // if highest is lower than start = dont sell

        Random rand = new Random();
        List<Integer> arrList = new ArrayList<Integer>();
        int length = 400;
        int insert;
        for(int i = 0; i < length; ++i){
            insert = rand.nextInt(150, 4000);
            arrList.add(insert);
        }

        System.out.println("Original stockList = " + arrList);
        insert = rand.nextInt(0, arrList.size()-1);
        largestProfit(arrList, insert);
    }

    public static void largestProfit(List<Integer> x, int startDate) {
        // startdate = startposition
        int buyPrice = x.get(startDate);
        System.out.println("Bought the stock for " + buyPrice + " at position " + startDate);
        int comparePrice = x.get(startDate + 1);
        for (int i = startDate + 2; i < x.size(); ++i) {
            if (x.get(i) > comparePrice) {
                comparePrice = x.get(i);
                System.out.println("New highest price is ==== " + comparePrice);
            }
        }

        int maxProfit = comparePrice - buyPrice;
        if (maxProfit <= 0) {
            // dont sell, it would be a loss
            System.out.println("You wouldnt sell the stock.. it would be a loss.. GAME OVER WAKAK WAKA WAKKA WAKA");
        } else {
            System.out.println("Max profit is " + maxProfit + ".. Since stock is bought at " + buyPrice + " and sold at " + comparePrice);
        }
    }
}