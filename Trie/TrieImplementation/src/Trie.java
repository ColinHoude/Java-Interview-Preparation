import java.util.*;

public class Trie {
    // possible problems with this -- uppercase and lowercase letters need to be converted to a single format
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public class TrieNode{
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(){}
    }

    public void insert(String word){
        TrieNode wordSearch = root;
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            // check if that letter is already present in the tree
            if(wordSearch.children[temp - 'a'] == null){
                wordSearch.children[temp - 'a'] = new TrieNode();
            }
            wordSearch = wordSearch.children[temp - 'a'];
        }
        wordSearch.isWord = true;
    }

    public boolean search(String word){
        TrieNode wordSearch = root;
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            // check if that letter is already present in the tree
            if(wordSearch.children[temp - 'a'] == null){
                return false;
            }
            wordSearch = wordSearch.children[temp - 'a'];
        }
        return wordSearch.isWord;
    }

    public boolean startsWith(String prefix){
        TrieNode wordSearch = root;
        for (int i = 0; i < prefix.length(); i++) {
            char temp = prefix.charAt(i);
            // check if that letter is already present in the tree
            if(wordSearch.children[temp - 'a'] == null){
                return false;
            }
            wordSearch = wordSearch.children[temp - 'a'];
        }
        return wordSearch.isWord;
    }



    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}