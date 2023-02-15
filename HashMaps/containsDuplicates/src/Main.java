import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive
        //There is only one repeated number in nums, return this repeated number.
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            arr.add(i);
        }
        Random rand = new Random();
        // then add the one extra duplicate
        arr.add(rand.nextInt(0,25));
        Collections.shuffle(arr);
        System.out.println(arr);
        arraySolution(arr);
        hashSolution(arr);
    }

    // going to solve this a few ways
    // first way using an Array that represents the number of occurances of that integer
    public static void arraySolution(List<Integer> x){
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            sol.add(0);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < x.size(); i++) {
            if(sol.get(x.get(i)) != 0){
                // this number is the duplicate
                ans = x.get(i);
                break;
            }
            else
                {
                    sol.set(x.get(i), 1);
                }
        }

        if(ans != Integer.MIN_VALUE){
            System.out.println(ans);
        }
        else
            System.out.println("no duplicates found");
    }

    // second way is using a HashMap that represents the frequency of that number
    public static void hashSolution(List<Integer> x ){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < x.size(); i++) {
            if(!set.add(x.get(i))){
                System.out.println(x.get(i));
                return;
            }
        }
        System.out.println("no solution found");
    }

}