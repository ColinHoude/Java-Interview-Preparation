import java.util.*;

public class Main {
    public static void main(String[] args) {
//You are given an integer array height of length n.
//      There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//      Return the maximum amount of water a container can store.
    List<Integer> arr = new ArrayList<>(Arrays.asList(1,8,6,2,5,4,8,3,7));
    maxArea(arr);
    }

    public static void maxArea(List<Integer> x ){
        int retVal = 0;
        // need to find the max area;
        // area = L*W
        // in this problem length = index
        // width = x.get(index)
        int distanceBetween = 0;
        int tempArea = 0;
        int i = 0;
        int j = x.size()-1;
        while(i < j){
            distanceBetween = j - i;
            tempArea = (Math.min(x.get(i), x.get(j)) * distanceBetween);
            if(tempArea > retVal){
                retVal = tempArea;
            }
            if(x.get(i) > x.get(j)){
                j--;
            }
            else
                i++;

        }

        System.out.println(retVal);

    }


}