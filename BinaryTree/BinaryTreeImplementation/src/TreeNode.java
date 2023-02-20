import javax.swing.*;
import java.util.*;

public class TreeNode {
    public static void main(String[] args) {
        // setting up binary tree
        List<Integer> listToTree = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            listToTree.add(i);
        }
        System.out.println(listToTree);
        TreeNode root = listToTree(listToTree, 0, listToTree.size()-1);
        printTree(root);
    }

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val){ this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.right = right;
        this.left = left;
    }

    public static TreeNode invertTree(TreeNode root){
        // recursion call until the tree points to null
        // also need a temp node to store middle while swapping
        if(root == null) return null;
        TreeNode Temp = root.left;
        root.left = root.right;
        root.right = Temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // print tree will print the tree in ascending order if correctly set up
    public static void printTree(TreeNode root){
        // this is just a basic print, id like to format it somehow
        if(root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);

    }

    public static void insertNode(TreeNode root, int val){
        root.val = val;
    }

    public static TreeNode listToTree(List<Integer> x, int left, int right){
        // need to sort list
        // binary search it to insert
        Collections.sort(x);
        if(left > right) return null;
        int mid = left + (right - left) /2;
        TreeNode root = new TreeNode(x.get(mid));
        root.left = listToTree(x, left, mid -1);
        root.right = listToTree(x, mid + 1, right);
        return root;
    }



}