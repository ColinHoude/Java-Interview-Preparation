import java.util.*;
public class Main {
    public static void main(String[] args) {
//        You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
//                You can perform this operation at most k times.
//        Return the length of the longest substring containing the same letter you can get after performing the above operations.

        String s = "AABABBA";
        longestReplacement(s, 3);
    }

    // this is the slow version although it is still linear
    public static void longestReplacement(String s, int k){
        // we need to always know the most frequent character of any given
        // substring and check if it is a valid substring
        // a valid substring is one where there is enough replacements 'K' such that
            // substring size - most frequent character <= K

        // answer
        int result = 0;

        HashSet<Character> hs = new HashSet<>();
        // collect all characters in the string
        for (int i = 0; i < s.length(); i++) {
            hs.add(s.charAt(i));
        }

        for (Character letter: hs){
            // need a left and right pointer
            int left = 0, right = 0;
            int count = 0;
            // set sliding window
            for(right = 0; right < s.length(); right+=1){
                if(s.charAt(right) == letter){
                    // if they are the same character -- no need to replace and can increase count
                    count+=1;
                }

                // now check if adding the new character is still a valid substring
                while(!isWindowValid(left, right, count, k)){
                    if(s.charAt(left) == letter){
                        // this letter does not work, so we will take that letter out from the front until it no longer
                        // is at the front
                        count -=1;
                    }
                    left +=1;
                }
                result = Math.max(result, right + 1 - left);
            }
        }
        System.out.println(result);
    }

    private static boolean isWindowValid(int start, int end, int count, int k){
        return end + 1 - start - count <= k;
    }
}