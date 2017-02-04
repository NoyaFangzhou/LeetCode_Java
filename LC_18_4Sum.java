/**
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note: The solution set must not contain duplicate quadruplets.
 *
 *
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 *	A solution set is:
 *	[
 *	  [-1,  0, 0, 1],
 *	  [-2, -1, 1, 2],
 *	  [-2,  0, 0, 2]
 *	]
 *
 */

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int length = nums.length;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for(int i = 0; i<length-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int temp = target - nums[i];
            for(int j = i+1; j< length-2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int low = j+1, high = length-1;
                while(low < high) {
                    if(nums[j] + nums[low] + nums[high] == temp) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low < high && nums[low] == nums[low+1]) {
                            low++;
                        }
                        while(low < high && nums[high] == nums[high-1]) {
                            high --;
                        }
                        low ++;
                        high --;
                    }
                    else if(nums[j] + nums[low] + nums[high] > temp) {
                        high --;
                    }
                    else {
                        low ++;
                    }
                }
            }
        }
        return result;
        
    }
}