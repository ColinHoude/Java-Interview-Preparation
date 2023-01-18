import java.util.ArrayList;
import java.util.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // remove duplicates from sorted array and return the number of non duplicate valid entries
        // first set up arrayList of random ints ranging from 0 to valid -- unvalid = valid++;
        Random rand = new Random();
        List<Integer> arrList = new ArrayList<Integer >();
        int nextRand;
        int nonvalid = 16;
        for(int i = 0; i < 8; ++i){
            // this will mean random numbers range form 0-15
            nextRand = rand.nextInt(nonvalid);
            arrList.add(nextRand);
        }
        Collections.sort(arrList);
        System.out.println("Now sorted array == " + arrList);
        System.out.println("Calling deleteDup");
        deleteDup(arrList,nonvalid );
        System.out.println("Now sorted array == " + arrList);
    }

    public static void deleteDup(List<Integer> x, int nonvalid){
        // deletes duplicates
        // returns number of elements after deleting duplicate
//        int nonDup = 0;
//        int tempHolder, tempHolder2;
//        for(int i = 0; i < x.size() -1; ++i){
//            tempHolder = x.
//            if(x.get(i-1) == x.get(i)){
//                tempHolder = x.get(i);
//                System.out.println("x[" + x.get(i-1) + "] and x[" + x.get(i) + "] are the same at place " + i);
//                x.set(i, nonvalid);
//
//            }
//        }
        int writeIndex = 1;
        for(int i = 1; i < x.size(); ++i){
            if(!x.get(writeIndex -1).equals(x.get(i))){
                System.out.println("CHANGING ARRAY SOMEHOW....");
                x.set(writeIndex++,x.get(i));
                System.out.println(x);
                System.out.println("writeIndex is " + writeIndex);
            }
        }
        System.out.println(writeIndex);
    }
}