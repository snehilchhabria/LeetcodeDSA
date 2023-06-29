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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(postorder.length != inorder.length) return null;
        return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length -1);
    }
    public TreeNode build(int[] postorder, int postLow, int postHi, int[] inorder, int inLow, int inHigh){
       if(inLow > inHigh || postLow > postHi){
           return null;
       }
        TreeNode root = new TreeNode(postorder[postHi]);
        
        int RootIdx = 0;
        for(int i= inLow; i<=inHigh; i++){
            if(inorder[i] == root.val){
                RootIdx = i;
                break;
            }
        }
        int leftTreeLen = RootIdx - inLow;
        int rightTreeLen = inHigh - RootIdx;
        
        root.left = build(postorder, postLow, postLow + leftTreeLen-1, inorder, inLow, RootIdx - 1);
        root.right = build(postorder, postHi - rightTreeLen, postHi -1, inorder, RootIdx + 1, inHigh);
        return root;
        
    }
}