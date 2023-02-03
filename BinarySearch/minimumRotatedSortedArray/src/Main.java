import java.util.*;

public class Main {
    public static void main(String[] args) {
//    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
//    results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//    Given the sorted rotated array nums of unique elements, return the minimum element of this array.
        // brute force would be to loop through the whole array and return the minimum
        // binary search to find -- x[i] > x[i+1]
        List<Integer> arr = new ArrayList<>(Arrays.asList(3,4,5,1,2));
        minNum(arr);
    }

    public static void minNum(List<Integer> x){
        int start = 0;
        int end = x.size()-1;
        while (end >= start){
            int mid = start + (end - start) / 2;
            if(x.get(mid) > x.get(mid+1)){
                System.out.println(x.get(mid+1));
                return;
            }
            if(x.get(mid-1) > x.get(mid)){
                System.out.println(x.get(mid));
                return;
            }
            if(x.get(mid) > x.get(0)){
                start = mid + 1;
            }
            else
                end = mid -1;
        }

        System.out.println("never found...");
    }
}