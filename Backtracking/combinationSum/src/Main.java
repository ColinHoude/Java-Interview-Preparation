import java.util.*;


// BACKTRACKING -- 2//


public class Main {
    static int numOfCalls = 0;
    public static void main(String[] args) {
        // Given an integer array nums of unique elements, return all possible subsets (the power set).
        // The solution set must not contain duplicate subsets. Return the solution in any order.
        List<List<Integer>> powerSet = new ArrayList<>();
        int nums[] = {2,3,6,7};
        int target = 7;
        powerSet = combinationSum(nums, target);
        System.out.println(powerSet);
        System.out.println(numOfCalls);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        // backtracking algorith
        List<List<Integer>> retList = new ArrayList<>();
        backTrack(retList, new ArrayList<>(), candidates,target, 0);
        return retList;
    }

    private static void backTrack(List<List<Integer>> list, List<Integer> tempList, int [] candidates,int target,  int start){
        numOfCalls++;
        if(target == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else if( target < 0 || start > candidates.length){
            return;
        }
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backTrack(list, tempList, candidates, target - candidates[i], i); // not i + 1 because we can reuse the same element to reach the end result
                tempList.remove(tempList.size()-1);
            }
        }
    }
}