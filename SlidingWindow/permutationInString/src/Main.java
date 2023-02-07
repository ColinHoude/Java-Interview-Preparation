import java.util.*;
public class Main {
    public static void main(String[] args) {
    // Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    // In other words, return true if one of s1's permutations is the substring of s2.
        permuationInString("abc", "bbbca");
    }

    public static boolean permuationInString(String s1, String s2){
        // if s1 is larger -- return false
        if(s1.length() > s2.length())
            return false;

        // need to look at every possible window of size s1
        // initialize HashMap for s1
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+1);
        }

        for (int i = 0; i < s2.length() - s1.length() ; i++) {
            // the outer for loop only checks the current substring of size s1
            HashMap<Character, Integer> s2Map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                // creates a new hashmap of substring of sliding window of size s1
                s2Map.put(s2.charAt(i + j), s2Map.getOrDefault(s2.charAt(i + j), 0)+1);
            }

            if(matches(s1Map, s2Map)){
                // compares to see if values are the same
                return true;
            }
        }

        // only hits this point after checking every possible substring and does not work
        return false;
    }

    private static boolean matches(HashMap<Character, Integer> s1Map, HashMap<Character, Integer> s2Map){
        for(char key: s1Map.keySet()){
            if(s1Map.get(key) - s2Map.getOrDefault(key, -1) != 0){
                return false;
            }
        }
        return true;
    }

    // this doesn't work for all cases, the question isn't too clear
    public static boolean substringInString(String s1, String s2){
        StringBuilder rev = new StringBuilder();
        rev.append(s1);
        rev.reverse();
        return (s2.contains(s1) || s2.contains(rev.toString()));
    }

    // now going to use same sliding window method but with integer array representing each number in the alphabet
    // and also checking the match count -- optimal way
    public static boolean slidingWindowArray(String s1, String s2){
        // if s1 is larger -- return false
        if(s1.length() > s2.length())
            return false;

        // need to look at every possible window of size s1
        // initialize HashMap for s1
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        // set up character array representing the correct permutations of s1
        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s1.charAt(i) - 'a']++;
        }

        // set up the initial number of matches
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if(s1Arr[i] == s2Arr[i]){
                matches++;
            }
        }

        for (int i = 0; i < s2.length()-s1.length(); i++) {
            // this is where sliding window comes in
            int right = s2.charAt(i + s1.length()) -'a';
            int left = s2.charAt(i) - 'a';
            if(matches == 26){
                return true;
            }

            s2Arr[right]++;
            if(s2Arr[right] == s1Arr[left]){
                matches++;
            }
            else if(s2Arr[right] == s1Arr[left] +1){
                // this is if s2Arr[left] does not match by one -- meaning the new s2Arr[right]
                // added a new character that does not match
                matches--;
            }

            s2Arr[left]++;
            if(s2Arr[left] == s1Arr[left]){
                matches++;
            }
            else if(s2Arr[right] == s1Arr[left] +1){
                // this is if s2Arr[left] does not match by one -- meaning the new s2Arr[right]
                // added a new character that does not match
                matches--;
            }
        }
        // only hits this point if it is checking the last possible substring at the end
        return matches == 26;
    }
}