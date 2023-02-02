import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        int row = 5;
        int column = 5;
        Random rand = new Random();
        int target = rand.nextInt(0,25);
        for (int i = 0; i < row; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr.get(i).add((i*column) + j);
            }
        }

        for (int i = 0; i < row; i++) {
            System.out.print("[");
            for (int j = 0; j < column; j++) {
                System.out.print(arr.get(i).get(j));
                if(j+1 != column){
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }

        //int derp = retRow(arr, target);
        //System.out.println(derp);
        //binSearchBruteForce(arr, target);
        binSearchCorrect(arr, target);

    }

    public static void binSearchCorrect(List<List<Integer>> x, int target){
        System.out.println("Looking for value: " + target + "...");
        int n = x.size(); // column size
        int m = x.get(0).size(); // number of rows
        int low = 0;
        int high = m*n -1;
        int comparisons = 0;
        while(low <= high){
            comparisons++;
            int mid = low + (high - low) /2;
            if(x.get(mid/m).get(mid%m) == target){
                System.out.println("Found the number !!");
                System.out.println("compared " + comparisons + " numbers...");
                return;
            }
            else if (x.get(mid/m).get(mid%m) < target){
                low = mid + 1;
            }

            else
                high = mid -1;
        }
        System.out.println("compared " + comparisons + " numbers...");
        System.out.println("EW EW EW TARGET NEVER FOUND...");
    }

    // this is the brute force method of this
    // time complexity O(N*M) -- essentially O(N^2)
    public static void binSearchBruteForce(List<List<Integer>> x, int target){
        System.out.println("Looking for value: " + target + "...");
        for (int i = 0; i < x.size(); i++) {
            for (int j = 0; j < x.get(i).size(); j++) {
                if(x.get(i).get(j) == target){
                    System.out.println("Found value at [" + i + "][" + j + "]");
                    System.out.println("compared " + ((i*5) + j) + " numbers...");
                    return;
                }
            }
        }

        System.out.println("never found value...");
    }
}