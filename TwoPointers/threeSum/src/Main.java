import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
        // such that i != j, i != k, and j != k,
        // and nums[i] + nums[j] + nums[k] == 0

        // this is basically two sum just with one additional check
        // this solution will also be a binary search after you sort the initial array
        List<Integer> arr = new ArrayList<>(Arrays.asList(-1,0,1,2,-1,-4));
        twoSumApproach(arr);
    }

    public static void twoSumApproach(List<Integer> x) {
        List<List<Integer>> retList = new ArrayList<>();
        Collections.sort(x);
        int sum;
        for (int i = 0; i < x.size()-2; i++) {
            int j = i+1;
            int k = x.size()-1;
            while(j < k){
                sum = x.get(i) + x.get(j) +x.get(k);
                if(sum == 0){
                    retList.add(new ArrayList<>(Arrays.asList(x.get(i), x.get(j++),x.get(k--))));
                }
                else if(sum < 0){
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        System.out.println(retList);
    }
}