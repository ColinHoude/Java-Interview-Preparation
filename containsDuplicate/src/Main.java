import java.util.*;

public class Main {
    //Given an integer array nums,
    //return true if any value appears at least twice in the array,
    //and return false if every element is distinct.
    public static void main(String[] args) {
        // randomly generate an arrayList of random integers to test
        List<Integer> arr = new ArrayList<>();
        Random rand = new Random();
        // randomly setting length of it
        for(int i = 0; i < 5;i++){
            arr.add(rand.nextInt(0,20));
        }
        Collections.sort(arr);
        System.out.println(arr);
        System.out.println(containsDuplicate(arr));
        System.out.println(duplicateHashSet(arr));
    }

    // this method sorts it then checks if the numbers next to each other are equivalent
    public static boolean containsDuplicate(List<Integer> x){
        Collections.sort(x);
        for (int i = 0; i < x.size()-1; i++) {
            if(x.get(i) == x.get(i+1)){
                // this will be the only time there is a duplicate -- break and return true
                return true;
            }
        }
        // no duplicate found
        return false;
    }

    // this method uses hashSets
    public static boolean duplicateHashSet(List<Integer> x){
        HashSet<Integer> hset = new HashSet<Integer>();
        for (Integer integer : x) {
            if (hset.contains(integer)) {
                return true;
            }
            // if not already present -- add to it
            hset.add(integer);
        }
        // it will only hit this with no duplicates found
        return false;
    }

}