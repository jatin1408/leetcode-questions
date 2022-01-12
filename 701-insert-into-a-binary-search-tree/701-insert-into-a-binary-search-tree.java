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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode getNode=findNode(root,val);
        if(getNode==null) return new TreeNode(val);
        if(getNode.val>val) getNode.left=new TreeNode(val);
        else getNode.right=new TreeNode(val);
        return root;
    }
    public TreeNode findNode(TreeNode root,int val){
        if(root==null) return null;
        TreeNode res=null;
        if(root.val>val) res=findNode(root.left,val);
        else res=findNode(root.right,val);
        if(res==null) return root;
        return res;
    }
}