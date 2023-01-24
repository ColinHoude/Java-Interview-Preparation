import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Given n pairs of parentheses,
        // write a function to generate all combinations of well-formed parentheses
        Random rand = new Random();
        int num = rand.nextInt(1,8);
        List<String> arr = generateParenthesis(3);
        System.out.println(arr);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> retList = new ArrayList<>();
        // only add open parenthesis if open < n
        // only add open parenthesis if open < n
        // valid IIF open == closed == n
        backTrack("", retList, 0, 0, n);
        return retList;
    }

    public static void backTrack(String sublist, List<String> x, int openN, int closedN, int n ){
        if(sublist.length() == 2*n){
            x.add(sublist);
            return;
        }
        if(openN<n){
            backTrack(sublist+ "(", x, openN+1, closedN, n);
        }
        if(openN > closedN){
            backTrack(sublist+ ")", x, openN, closedN+1, n);
        }

    }
}