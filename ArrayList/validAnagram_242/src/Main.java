import java.util.Arrays;
import java.util.Collections;

public class Main {
//    Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//    typically using all the original letters exactly once.


    // ---- solution thought out ----

    // 1 - create array of ints with size 26 for all lowercase letters
    // essentially it is a hashmap
    // store[0] represents 'a'
    // store[26] represents 'z'
    // if store[0] == 4 -- that means there is 4 occurrences of the letter 'a' in the string

    public static void main(String[] args) {
        System.out.println("Hello anagram tester!");
        String s = "anagram";
        String t = "naagram";
        System.out.println(validSort(s, t));
        System.out.println(valid(s, t));
    }

    // this solution uses an array that represents each character
    public static boolean valid(String s, String t){
        if(s.length() != t.length()) return false;
        int[] store = new int[26];
        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }
        //System.out.println(Arrays.toString(store));
        for(int n: store) if(n != 0) return false;
        return true;
    }

    // this solution uses a sort algorithm
    public static boolean validSort(String s, String t){
        if(s.length() != t.length()) return false;
        else{
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            Arrays.sort(ss);
            Arrays.sort(tt);
            System.out.println(ss);
            System.out.println(tt);
            for (int i = 0; i < ss.length; i++) {
                if(ss[i] != tt[i]) return false;
            }
            return true;
        }

    }
}