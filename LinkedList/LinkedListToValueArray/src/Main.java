import java.util.*;
public class Main {
    public static void main(String[] args) {
        // in this program I will randomly add values to the linked list
        // then traverse the linked list while adding the values to an ArrayList and return it as an Array
        LinkedList<Integer> intList = new LinkedList<>();

        Random rand = new Random();
        // 25 random values
        for (int i = 0; i < 25; i++) {
            intList.add(rand.nextInt(-100, 100));
        }

        // List to Array
        List<Integer> arrList = listToArray(intList);
        Collections.sort(arrList);
        System.out.println(arrList);
    }

    public static List<Integer> listToArray(LinkedList<Integer> x){
        List<Integer> retArr = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            retArr.add(x.get(i));
        }
        return retArr;
    }
}