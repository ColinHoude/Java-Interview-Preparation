import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Given a string s, find the length of the longest substring without repeating characters
        // set for substring
        // sliding window -- remove elements from the left while adding one to the right
        // sliding window -- O(N) - only have to go through the array loop once
        String s = "abcabcbb";
        String alpha = "abcdefghijklmnopqrstuvwxyz1234567890";
        longestSubString(s);
        longestSubString(alpha);
    }

    public static void longestSubString(String s){
        int maxCount = 0;
        Map<Character, Integer> chars = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char tempRight = s.charAt(right);
            chars.put(tempRight, chars.getOrDefault(tempRight, 0) +1);

            while(chars.get(tempRight) > 1){
                char tempLeft = s.charAt(left);
                chars.put(tempLeft, chars.get(tempLeft) -1);
                left++;
            }
            maxCount = Math.max(maxCount, right - left +1);
            right++;
        }

        System.out.println(maxCount);
    }
}