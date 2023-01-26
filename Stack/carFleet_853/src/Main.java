import java.util.*;

public class Main {
    public static void main(String[] args) {
//        another monotonic Stack Problem

//        - sort cars by start position
//        - loop from end to beginning (car closest to target first)
//        - calculate the time it needs to arrive at the target
//          - store the slowest time

//        - if another car is equal or less than the slowest time
//          - faster and will catch up
//
//        - if another car needs more time
//          - it will be the new slowest car and becomes the new lead car of a fleet

        List<Integer> position = new ArrayList<>(Arrays.asList(10,8,0,5,3));
        List<Integer> speed = new ArrayList<>(Arrays.asList(2,4,1,1,3));
        int target = 12;

        System.out.println(carFleet(target, position, speed));

    }

    public static int carFleet(int target, List<Integer> pos, List<Integer> spd){
        // linear equation problem
        // speed = slope on a graph
        if(pos.size() <= 1){
            return pos.size();
        }
        // create a new 2d array then sort
        double [][] cars = new double [pos.size()][2];
        int retVal = 0;
        for (int i = 0; i < pos.size(); i++) {
            cars[i] = new double[]{pos.get(i), (double)(target - pos.get(i)) / spd.get(i)};
        }
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double current = 0;
        for (int i = pos.size() -1; i >= 0; i--) {
            if(cars[i][1] > current){
                current = cars[i][1];
                retVal++;
            }
        }
        return retVal;
    }
}