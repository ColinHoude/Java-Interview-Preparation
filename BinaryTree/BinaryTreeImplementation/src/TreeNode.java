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
        // rebalancing is built into the listToTree function -- just pass new list into it
        TreeNode root = listToTree(listToTree, 0, listToTree.size()-1);
        printTree(root);
        System.out.println();
        printCurrentNode(root);
        for (int i = 6; i < 11; i++) {
            listToTree.add(i);
        }
        System.out.println(listToTree);
        root = listToTree(listToTree, 0, listToTree.size()-1);
        printTree(root);
        System.out.println();
        printCurrentNode(root);
        //searchForValue(root, 6);
//        List<Integer> rebalanceTree = treeToList(root);
//        Collections.shuffle(rebalanceTree);
//        System.out.println(rebalanceTree);

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

    public static List<Integer> getAllTreeValue(TreeNode root, List<Integer> x){
        // same as print but return the value
        if(root == null) return x;
        else{
            getAllTreeValue(root.left, x);
            getAllTreeValue(root.right, x);
            x.add(root.val);
        }
        return x;
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

    public static void searchForValue(TreeNode root, int val){
        // this is a basic search for value function of a BST
        // not sure if a recursion call or a while loop would be better, probably a while loop
        if(root == null) {
            System.out.println("value never found...");
        }
        else if(root.val == val){
            System.out.println("value found -- " + val);
        }
        // this is where recursion calls come in
        else if(root.val > val){
            // need a smaller value -- go to the left
            searchForValue(root.left, val);
        }
        else {
            // need a larger value
            searchForValue(root.right, val);
        }
    }

    public static void searchForValWhile(TreeNode root, int val){
        // searching for val using a while loop instead of reccursion
        while(root != null || root.val != val){
            if(root.val > val){
                root = root.left;
            }
            else
                root = root.right;
        }

        if(root == null){
            System.out.println("value never found -- " + val);
        }

        else
            System.out.println("value found -- " + val);


    }

    public static void deleteValue(TreeNode root, int val){
        // some complications of deletion
            // has zero children
            // has one child
            // has two children
        TreeNode temp = new TreeNode();
        // traverse to the node of value
        if(root == null){
            System.out.println("value not in tree -- cant delete");
            return;
        }

        if(root.val == val){
            // this is where we delete

        }
    }

    // this function is used to re-balance the tree
    public static List<Integer> treeToList(TreeNode root){
        List<Integer> retList = new ArrayList<>();
        retList = getAllTreeValue(root, retList);
        Collections.sort(retList);
        return retList;
    }

    public static void printCurrentNode(TreeNode root){
        System.out.println("The current top node value is -- " + root.val);
    }

//    public static TreeNode rebalance(TreeNode root){
//     // rebalancing a root
//
//    }

}