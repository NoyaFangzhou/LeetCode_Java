/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

 */
 
public class Solution {
    public int missingNumber(int[] nums) {
        
        // int[] temp = new int[nums.length+1];
        
        // for(int num: nums) {
        //     temp[num] = 1;
        // }
        // System.out.println(toString(temp));
        // for(int i = 0; i<temp.length; i++) {
        //     if(temp[i] == 0) {
        //         return i;
        //     }
        // }
        // return -1;
        int res = 0 , i=0;
        
        for(; i<nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        
        return res ^ nums.length;
    }
    
    private String toString(int[] num) {
        String s = "";
        for(int n: num) {
            s += n + " ";
        }
        return s;
    }
}