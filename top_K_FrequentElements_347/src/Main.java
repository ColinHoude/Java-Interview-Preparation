import java.util.*;

public class Main {
    public static void main(String[] args) {
        // we will first create a random list of integers to use for testing
        Random rand = new Random();
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            arr.add(rand.nextInt(1,10));
        }
        Collections.sort(arr);
        System.out.println(arr);
        topFreq(arr,rand.nextInt(1, 10));
    }

    public static List<Integer> topFreq(List<Integer> x, int k){
        // use a hashMap then return the k most frequent elements -- elements with the highest values
        System.out.println("k = " + k);
        Map<Integer, Integer> retMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < x.size(); i++) {
            int count = retMap.getOrDefault(x.get(i), 0);
            retMap.put(x.get(i), count +1);
        }
        System.out.println(retMap);
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> retMap.get(n1) - retMap.get(n2));

        for(int n: retMap.keySet()){
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }

        List<Integer> retList = new ArrayList<Integer>();
        for (int i = k-1; i >= 0; i--) {
            retList.add(heap.poll());
        }
        System.out.println(retList);
        return retList;
    }
}