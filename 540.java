/*
 * 540. Single Element in a Sorted Array
 *问题描述:给定一个排序的数组，只有一个数只出现一次，其余都出现2次，找出出现一次的数，时间复杂度o(logn),空间复杂度o(1).
 *问题分析:二分查找
 */

 class Solution {
     public int singleNonDuplicate(int[] nums) {
         int index=help(nums,0,nums.length-1);
         // System.out.println(index);
         return index==-1?-1:nums[index];
     }

     public int help(int[] nums, int start, int end){
         // System.out.println(start+":"+end);
         if(start>end) return -1;
         if(start==end)
             return start;
         int mid=start+(end-start)/2;
         int temp;
         if(mid>0&&nums[mid]==nums[mid-1]){
             temp=help(nums,start,mid-2);
             if(temp!=-1) return temp;
             temp=help(nums,mid+1,end);
             if(temp!=-1) return temp;
         }
         else if(mid<nums.length-1&&nums[mid]==nums[mid+1]){
             temp=help(nums,mid+2,end);
             if(temp!=-1) return temp;
             temp=help(nums,start,mid-1);
             if(temp!=-1) return temp;
         }
         return -1;
     }
 }
