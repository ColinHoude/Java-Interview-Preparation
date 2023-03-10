import java.util.*;

public class Main {
    public static void main(String[] args) {
        //    Given an array of integers temperatures represents the daily temperatures,
        //    return an array answer such that answer[i] is the number of days you have to wait after the ith day
        //    to get a warmer temperature.
        //    If there is no future day for which this is possible, keep answer[i] == 0 instead.
        List<Integer> arr = new ArrayList<>(Arrays.asList(73,74,75,71,69,72,76,73));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(30,40,50,60));
        List<Integer> arr3 = new ArrayList<>(Arrays.asList(30,60,90));
        BruteForce(arr);
        BruteForce(arr2);
        BruteForce(arr3);
        System.out.println("--------------");
        usingStack(arr);
        usingStack(arr2);
        usingStack(arr3);
        //stackTester();
    }


    // this is a brute force method that is slow and uses O(N^2) time complexity
    public static void BruteForce(List<Integer> x){
        List<Integer> xyz = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            int tempTemp = x.get(i);
            int tempDays = 0;
            boolean hotterDay = false;
            for (int j = i+1; j < x.size(); j++) {
                tempDays++;
                if(tempTemp < x.get(j)){
                    xyz.add(tempDays);
                    hotterDay = true;
                    break;
                }
            }
            if(!hotterDay){
                xyz.add(0);
            }
        }
        System.out.println(xyz);
    }

    public static void usingStack(List<Integer> x) {
        // this solution uses a monotonic Stack
        // this is the first time I have heard of a monotonic Stack
        Stack<Integer> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        for (int i = x.size()-1; i >= 0; i--) {
            while (!st.isEmpty() && x.get(i) > x.get(st.peek())) {
                st.pop();
            }
            if (!st.isEmpty()) {
                res.add(st.peek() - i);
            }
            st.push(i);
        }
        System.out.println(res);
    }

    public static void stackTester(){
        // I am just testing all the stack calls here
        Random rand = new Random();
        Stack<Integer> sta = new Stack<>();
        for (int i = 0; i < 7; i++) {
            sta.push(rand.nextInt(1,1000));
        }

        System.out.println(sta);
        System.out.println(sta.peek());
        System.out.println(sta.get(2));
        sta.pop();
        System.out.println(sta);
    }

}

