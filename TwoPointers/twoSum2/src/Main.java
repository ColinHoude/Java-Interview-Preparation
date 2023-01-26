import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,7,11,15));
        twoSum(arr, 9);
        twoSumBinary(arr, 9);
    }

    // brute force method using a nested for loop -- slow
    public static void twoSum(List<Integer> x, int target){
        List<Integer> retList = new ArrayList<>();
        for (int i = x.size()-1; i >= 0; i--) {
            if(x.get(i) < target){
                for (int j = 0; j != i; j++) {
                    if(x.get(j) + x.get(i) == target){
                        retList.add(j+1);
                        retList.add(i+1);
                        break;
                    }
                }
            }
        }
        System.out.println(retList);
    }

    // we can use binary search because we know the array is sorted
    // Sorted array = use binary search
    public static void twoSumBinary(List<Integer> x, int target){
        int i = 0;
        int j = x.size()-1;
        List<Integer> retList = new ArrayList<>();
        while(i < j){
            if(x.get(i) + x.get(j) == target){
                retList.add(i+1);
                retList.add(j+1);
                break;
            }
            else if(x.get(i) + x.get(j) < target){
                i++;
            }
            else
                j--;
        }
        System.out.println(retList);
    }
}