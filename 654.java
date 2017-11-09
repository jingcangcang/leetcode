/**
  * 654.Maximum Binary Tree
  * 题目描述：给定一个不包含重复元素的数组构建一个最大二叉树，树的根节点是当前数组元素中最大的。
  * 题目分析：引入一个help函数，传入当前数组的有效范围，然后将此数组中最大的值作为根节点的值，此值左边的为左节点，右边的为右节点，以此递归构建树。
  */
/**
  * Definition for a binary tree node.
  * public class TreeNode {
  *     int val;
  *     TreeNode left;
  *     TreeNode right;
  *     TreeNode(int x) { val = x; }
  * }
  */
 class Solution {
     public TreeNode constructMaximumBinaryTree(int[] nums) {
         if(nums==null)
             return null;
         return help(nums,0,nums.length-1);
     }

     public TreeNode help(int[] nums, int start, int end){
         if(start>end)
             return null;
         if(start==end){
             TreeNode root=new TreeNode(nums[start]);
             return root;
         }
         int index=start, maxNum=nums[start];
         for(int i=start+1;i<=end;i++){
             if(nums[i]>maxNum){
                 index=i;
                 maxNum=nums[i];
             }
         }
         TreeNode root=new TreeNode(maxNum);
         root.left=help(nums,start,index-1);
         root.right=help(nums,index+1,end);
         return root;
     }
    
 }

