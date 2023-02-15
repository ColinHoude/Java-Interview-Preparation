public class TreeNode {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val){ this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.right = right;
        this.left = left;
    }



}