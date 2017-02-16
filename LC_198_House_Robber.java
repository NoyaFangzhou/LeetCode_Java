/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that 
adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class Solution {
    public int rob(int[] nums) {
        
        int length = nums.length;
        
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        // current status, pre status, and pre 2 status
        int cur = 0, pre = 0, pre2 = 0;
        for(int m: nums) {
            cur = Math.max(pre2+m, pre);
            pre2 = pre;
            pre = cur;
        }
        
        return cur;
        
        
        
    }
}