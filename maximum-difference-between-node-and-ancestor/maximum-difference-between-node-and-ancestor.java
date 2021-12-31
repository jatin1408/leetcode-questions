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
    int maxDiff=0;
    int minDiff=0;
    
    public int maxAncestorDiff(TreeNode root) {
            dfs1(root,root.val);
            dfs2(root,root.val);
            return Math.max(maxDiff,minDiff);
    }
    public void dfs1(TreeNode root,int max){
        if(root==null) return;
        maxDiff=Math.max(maxDiff,Math.abs(root.val - max));
        dfs1(root.left,Math.max(max,root.val));
        dfs1(root.right,Math.max(max,root.val));
    }
    
    public void dfs2(TreeNode root,int min){
        if(root==null) return;
        minDiff=Math.max(minDiff,Math.abs(root.val - min));
        dfs2(root.left,Math.min(min,root.val));
        dfs2(root.right,Math.min(min,root.val));
    }
    
    
}