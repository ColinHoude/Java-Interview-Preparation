import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // koko loves these bananas i guess
        // he must be monki

//Koko loves to eat bananas.
    //There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//Koko can decide her bananas-per-hour eating speed of k.
//Each hour, she chooses some pile of bananas and eats k bananas from that pile.
// If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//Return the minimum integer k such that she can eat all the bananas within h hours
        List<Integer> piles = new ArrayList<>(Arrays.asList(3, 6, 7 , 11));
        minEatingSpeed(piles, 8);
        bruteForce(piles, 8);
    }

    public static void minEatingSpeed(List<Integer> x, int hours){
        // first sort the array
        Collections.sort(x);
        int minSpeed = 0;
        int comparisons = 0;
        if(x.size() >=  hours){
            // if he only has 5 hours to eat 5 piles, he must eat one pile an hour
            // therefore he must be eating at least the speed of the largest pile
            System.out.println(x.get(x.size()-1));
        }

        else {
            // binary search
            int low = 1;
            int high = x.get(x.size()-1);
            while (low < high){
                comparisons++;
                int mid = low + (high - low) / 2;
                if(canEatAll(x, mid, hours)){
                    minSpeed = mid;
                    high = mid -1;
                }
                else
                    low = mid + 1;
            }
            System.out.println("Speed of: " + minSpeed + " bananas per hour and took " + comparisons + " comparisons to come up with that answer...");
        }

    }

    public static boolean canEatAll(List<Integer> x, int rate, int hours){
        int totalHours = 0;
        for (int i = 0; i < x.size(); i++) {
            totalHours += (int)Math.ceil(x.get(i)*1.0 / rate);
        }
        System.out.println("total hours to be eaten = " + totalHours);
        return totalHours<=hours;
    }

    public static void bruteForce(List<Integer> x, int hours){
        // first sort to get the max value
        Collections.sort(x);
        int minSpeed = 0;
        int comparisons = 0;
        int maxVal = x.get(x.size()-1);
        for (int i = 1; i < maxVal; i++) {
            minSpeed = i;
            for (int j = 0; j < x.size(); j++) {
                comparisons++;
                if(!canEatAll(x, minSpeed, hours)){
                    System.out.println("Speed of: " + minSpeed + " bananas per hour and took " + comparisons + " comparisons to come up with that answer...");
                    break;
                }
            }
        }
    }
}