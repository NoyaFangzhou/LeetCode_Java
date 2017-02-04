/**
 *
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *	
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int min = nums[0]+nums[1]+nums[length-1];
        int min_gap = Integer.MAX_VALUE;
        for(int i = 0; i<length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int low = i+1, high = length-1;
            while(low < high) {
                int sum = nums[i]+nums[low]+nums[high];
                if(sum == target ){
                    return sum;
                }
                if (sum > target) {
                    high --;
                }
                else if(sum < target) {
                    low ++;
                }
                if (min_gap > Math.abs(sum-target)) {
                    min_gap = Math.abs(sum-target);
                    min = sum;
                }
            }
        }
        return min;   
    }
}

