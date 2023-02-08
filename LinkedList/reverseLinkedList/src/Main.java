import java.util.*;
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();

        for (int i = 0; i < 25; i++) {
            intList.add(i);
        }
        System.out.println(intList);
        intList = reverseList(intList);
        System.out.println(intList);
    }

    public static LinkedList<Integer> reverseList(LinkedList<Integer> list){
        LinkedList<Integer> retList = new LinkedList<>();
        // use recursion to get the last to the front
        for (int i = list.size()-1; i >= 0; i--) {
            retList.add(list.get(i));
        }
        return retList;
    }


}