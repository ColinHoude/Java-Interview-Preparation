import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // We take in two arrays,
        // one array represents the original order we want to preform the permutation on
        // the second array represents the order which we must change the first array to
        // Array A = [0,1,2,3,4]
        // Array B = [2,3,4,0,1]
        // we must swap A[0] to A[2] since A[0] == 0 -- B[0] == 2

        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();
        int length = 10;
        for(int i = 0; i < length; i++){
            A.add(i);
            B.add(i);
        }

        // create a permutation order
        Collections.shuffle(A);
        System.out.println(A);
        System.out.println(B);
        permutate(A, B);
        System.out.println("Preforming permuitation");
        System.out.println(A);
        System.out.println(B);



    }

    public static void permutate(List<Integer> X, List<Integer> Y){
        // use sign bit to keep track of which elemetns have
        // assuming they are the same length

        // x = perm
        // y = A
        if(X.size() != Y.size() || X.size() == 0){}

        else{
            // store int
            int next;
            int temp;
            for(int i = 0; i < X.size(); i++){
                //X.get(i) == location of x[0]
                next = i;
                while(X.get(i) >= 0){ // if negative == that means the permutation has already been made
                    // swap whatever is at location i with whatever location the value of i points too
                    System.out.println("Swapping element Y[" + i + "] with element X.get(" + X.get(i) + ")");
                    Collections.swap(Y, i, X.get(i));
                    temp = X.get(next);
                    System.out.println("temp is now " + temp);
                    X.set(next, X.get(next) - X.size()); // changing it to negative
                    next = temp;
                }
            }

            // restore perm
            // why?
            for(int i = 0; i < X.size(); i++){
                X.set(i, X.get(i) + X.size());
            }
        }

    }
}