import java.util.*;

public class Main {

//    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//    typically using all the original letters exactly once.
    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        System.out.println(Arrays.toString(strs));

        System.out.println(groupAnagrams2(strs));
    }

    // this solution partially worked; sub par less than ideal
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> retList = new ArrayList<List<String>>();
        for (int i = 0; i < strs.length; i++) {
            if(!retList.contains(strs[i])){
                retList.add(new ArrayList<String>());
                retList.get(i).add(strs[i]);
                for (int j = i+1; j < strs.length; j++) {
                    if(valid(strs[i],strs[j])){
                        retList.get(i).add(strs[j]);
                    }
                }
            }
        }
        return retList;
    }

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

    // this solution uses Map and works
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}