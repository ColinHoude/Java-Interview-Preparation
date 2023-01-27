import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Bubble sort is very slow
        // has to iterate through the array n^2 times
        // only sorts the largest number to the end of each iteration
        // only sorts one value to the guaranteed correct spot




        System.out.println("Hello bubble sort!");
        List<Integer> arr = new ArrayList<Integer>();
        Random rand = new Random();
        //int limit = rand.nextInt(1, 10);
        for (int i = 0; i < 10 ; i++) {
            arr.add(rand.nextInt(-1000,1000));
        }

        System.out.println(arr);
        bubble(arr);
    }

    public static void bubble(List<Integer> x){
        // run the steps n-1 times
        int totalIterations = 0;
        boolean isSortedalready;
        for (int i = 0; i < x.size(); i++) {
            // for each iteration, max element will come at the last respective index
            isSortedalready = false;
            for (int j = 1; j < x.size() -i; j++) {
                // compare elements
                // swap if the item is smaller than the previous element
                if(x.get(j) < x.get(j-1)){
                    // Collections takes in ( arrayList, index of element to swap, index of element being swapped
                    Collections.swap(x, j, j-1);
                    isSortedalready = true;
                }
                totalIterations++;
            }

            if(!isSortedalready){
                //this means it did not swap a single element == already sorted
                //System.out.println("Array already sorted...");
                System.out.println(x);
                System.out.println("Total times ran through -- " + totalIterations);
                return;
            }
        }
        System.out.println(x);
        System.out.println("Total times ran through -- " + totalIterations);
    }
}