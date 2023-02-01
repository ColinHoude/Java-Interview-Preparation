import java.util.*;

public class Main {
    public static void main(String[] args) {
        // basic binary search function
        // generating a random array to test
        Random rand = new Random();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            arr.add(rand.nextInt(1, 100));
        }

        Collections.sort(arr);
        System.out.println(arr);
        System.out.println();
        binSearch(arr, rand.nextInt(1,100));
    }

    // binary search of this function
    public static void binSearch(List<Integer> x, int target){
        System.out.println("Looking for value: " + target + "...");
        int start = 0;
        int end = x.size()-1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(x.get(mid) == target){
                System.out.println("found " + target + " at [" + mid + "]");
                break;
            }
            else if(x.get(mid) < target){
                start = mid + 1;
            }
            else
                end = mid -1;
        }
        System.out.println("value never found");
    }

    // brute force method of this function
    public static void binSearchBruteForce(List<Integer> x, int target){
        System.out.println("Looking for value: " + target + "...");
        for (int i = 0; i < x.size(); i++) {
            if(x.get(i) == target){
                System.out.println("Found target at: [" + i + "]");
                return;
            }
        }

        System.out.println("Never found...");
    }
}