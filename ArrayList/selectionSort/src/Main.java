import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- hello selection sort ---");

        // select a single element and put it at its correct position
        // only swap one element -> not the whole array

        // [4,5,1,2,3] -> [4,3,1,2,5]

        //List<Integer> arr = new ArrayList<>(Arrays.asList(4,5,1,2,3));
        List<Integer> arr = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 25; i++) {
            //arr.add(rand.nextInt(1,150000));
            arr.add(rand.nextInt(1,35000));
        }

        System.out.println(arr);
        selectionSort(arr);
    }

    static void selectionSort(List<Integer> x){
        int maximum = x.get(0);
        for (int i = 0; i < x.size(); i++) {
            int swap = retMax(x, x.size()-i);
            //System.out.println("swap - " + swap + " to be swapped with " + (x.size()-i));
            Collections.swap(x,swap, x.size()-i-1);
        }
        System.out.println(x);
    }

    static int retMax(List<Integer> x, int y){
        // y represents range the array needs to check too
        int maximum = x.get(0);
        int position = 0;
        for (int i = 0; i < y; i++) {
            if(x.get(i) > maximum){
                maximum = x.get(i);
                position = i;
            }
        }
        //System.out.println("the maximum value is -- " + maximum + " and is located at [" + position + "]");
        return position;
    }

}