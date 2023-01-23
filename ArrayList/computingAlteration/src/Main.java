import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // write a program that takes in an arrar A of integers and sorts them so
        // A[0] <= A[1] >= A[2] <= A[3] ....
        // [0] = 0, [1] = 2, [2] = 1, [3] = 4
        // a question of odd or even
        // even, odd, even, odd
        // first set up initial ArrayList
        List<Integer> arrList = new ArrayList<Integer>();
        int range = 10;
        Random rand = new Random();
        int x;
        for(int i = 0; i < range; ++i){
            x = rand.nextInt(1000);
            arrList.add(x);
        }
        System.out.println("Before swap = " + arrList);
        reaArrange(arrList);
        System.out.println("After swap = " + arrList);

    }

    public static void reaArrange(List<Integer> x){
        for(int i = 1; i < x.size(); ++i){
            // check if it is a even number
            // if i is even number, check if it is less than the number to the right of it == swap
            // if i is odd number, check if it is greater than the number to the left of it == swap
            if(((i % 2) == 0&& x.get(i -1) < x.get(i)) || ((i % 2) != 0 && x.get(i -1) > x.get(i))){
                Collections.swap(x, i-1, i);
            }
        }
    }
}