import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        int row = 5;
        int column = 5;
        Random rand = new Random();
        int target = rand.nextInt(0,25);
        for (int i = 0; i < row; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr.get(i).add((i*column) + j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.println();
        }

        int derp = retRow(arr, target);
        System.out.println(derp);

    }

    public static int retRow(List<List<Integer>> x, int target){
        int columnNum = 0;
        System.out.println("searching for target: " + target);
        int start = 0;
        int end = x.get(0).size()-1;
        while(start < end){
            int mid = start + (end - start) /2;
            if(x.get(mid).get(end) == target){
                System.out.println("found " + target + " at [" + mid + "]");
                break;
            }

            else if (x.get(mid).get(x.get(mid).size()-1) < target && x.get(mid+1).get(x.get(mid+1).size()-1) > target){
                // this is the return row
                columnNum = mid+1;
                break;
            }

            else if (x.get(mid).get(x.get(mid).size()-1) < target && x.get(mid+1).get(x.get(mid+1).size()-1) < target){
                start = mid + 1;
            }

            else
                end = mid -1;
        }

        return columnNum;

    }
}