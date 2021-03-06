/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.

*/

public class Solution {
    public boolean search(int[] nums, int target) {
        
        int length = nums.length;
        
        int left = 0, right = length-1;
        
        while(left <= right) {
            int mid = left+(right-left)/2;
            if(nums[mid] == target) {
                return true;
            }
            // increase at left side 
            else if(nums[mid] > nums[left]) {
                if(nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            // increase at right side
            else if(nums[mid] < nums[left]) {
                if(nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                }
                else {
                    right = mid -1;
                }
            }
            else {
                left ++;
            }
        }
        
        return false;
        
        
    }
}