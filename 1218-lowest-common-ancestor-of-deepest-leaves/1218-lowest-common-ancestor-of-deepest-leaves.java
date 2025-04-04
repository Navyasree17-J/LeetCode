/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return findLCA(root,0).node; 
    }
    private Result findLCA(TreeNode node, int depth){
        if(node == null){
            return new Result(null, depth);
        }
        Result left = findLCA(node.left,depth+1);
        Result right = findLCA(node.right, depth+1);
        if(left.depth == right.depth){
            return new Result(node, left.depth);
        }
        if(left.depth > right.depth){
            return left;
        }else{
            return right;
        }
    }
    private static class Result{
        TreeNode node;
        int depth;
        Result(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
}