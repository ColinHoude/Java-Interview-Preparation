import java.util.*;

public class Main {

    //  Given an integer array nums, return an array answer such that answer[i] is equal to
    //  the product of all the elements of nums except nums[i]

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i < 5; i++) {
            arr.add(i);
        }
//        arr.add(-1);
//        arr.add(1);
//        arr.add(0);
//        arr.add(-3);
//        arr.add(3);
        System.out.println(arr);
        allProductExceptBetter(arr);
    }

    // this solution works, but it is O(N^2) time complexity due to the nested for loop
    public static List<Integer> allProductExcept(List<Integer> x){
        List<Integer> retList = new ArrayList<Integer>();
        for (int i = 0; i < x.size(); i++) {
            int inputVal = 1;
            for (int j = 0; j < x.size(); j++) {
                if(j != i){
                    inputVal *= x.get(j);
                }
            }
            retList.add(inputVal);
        }
        System.out.println(retList);
        return new ArrayList<>();
    }

    // this solution is O(N)
    public static List<Integer> allProductExceptBetter(List<Integer> x){
        List<Integer> retList = new ArrayList<Integer>();
        // multiply left side
        int start = 1;
        for (int i = 0; i <x.size() ; i++) {
            retList.add(start);
        }

        for (int i = 0; i < x.size(); i++) {
            retList.set(i, start*retList.get(i));
            start *= x.get(i);
        }

        start = 1;
        for (int i = x.size()-1; i >= 0; i--) {
            retList.set(i, start*retList.get(i));
            start *= x.get(i);
        }
        System.out.println(retList);

        return new ArrayList<>();
    }
}