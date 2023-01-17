import java.lang.reflect.Array;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        boolean[] boolArra = new boolean[6];
        int trueNums = 0;
        int falseNums = 0;
        for(int i = 0; i < boolArra.length -1; i++){
            boolArra[i] = rand.nextBoolean();
            System.out.println(boolArra[i]);
            if(boolArra[i]){
                trueNums++;
            }
            else falseNums++;
        }

        System.out.println("Number of true statements -- " + trueNums);
        System.out.println("Number of false statements -- " + falseNums);
        sortBool(boolArra);

        for(int i = 0; i < boolArra.length -1; i++){
            System.out.println(boolArra[i]);
        }

    }

    public static void sortBool(boolean[] x){
        System.out.println("Calling sortBool....");
        int min = 0;
        for (int i = x.length -1; i >= min; --i){
            while(!x[i]){
                if(x[min]){
                    System.out.println("SWAPPING x[" + min + "]" + " AND x[" + i + "]");
                    x[min] = false;
                    x[i] = true;
                }
                // if they both false
                min++;
            }
        }

//        for(int i = 0; i < x.length -1; i++){
//            while(x[i]){
//                // this is true, push to the back
//                if(x[max]){
//                    max--;
//                }
//                else{
//                    x[i] = false;
//                    x[max] = true;
//                    max--;
//                }
//            }
//        }

        // start from the back
    }
}