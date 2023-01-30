import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        int row = 5;
        int column = 5;
        for (int i = 0; i < row; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println(column * (i + j));
            }
        }

        System.out.println(arr);
    }
}