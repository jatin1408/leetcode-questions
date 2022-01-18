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
    int index=0;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return create(preorder,inorder,0,preorder.length);
    }
    public TreeNode create(int[] preorder,int[] inorder,int low,int high){
         if(low>high || index>=preorder.length) return null;
        if(low==high) return new TreeNode(preorder[index++]);
      
        int val=preorder[index++];
        int targetIndex=map.get(val);
        TreeNode root=new TreeNode(val);
        root.left=create(preorder,inorder,low,targetIndex-1);
        root.right=create(preorder,inorder,targetIndex+1,high);
        return root;
    }
   
}