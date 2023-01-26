import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,7,11,15));
        twoSum(arr, 9);
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
}