import java.util.*;


// BACKTRACKING //


public class Main {
    static int numOfCalls = 0;
    public static void main(String[] args) {
        // Given an integer array nums of unique elements, return all possible subsets (the power set).
        // The solution set must not contain duplicate subsets. Return the solution in any order.
        List<List<Integer>> powerSet = new ArrayList<>();
         int nums[] = {1,2,3, 4};
         powerSet = subSet(nums);
         System.out.println(powerSet);
        System.out.println(numOfCalls);
    }

    public static List<List<Integer>> subSet( int [] nums){
        // backtracking algorith
        List<List<Integer>> retList = new ArrayList<>();
        backTrack(retList, new ArrayList<>(), nums, 0);
        return retList;
    }

    private static void backTrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        numOfCalls++;
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i +1);
            tempList.remove(tempList.size()-1);
        }
    }
}