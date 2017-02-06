/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    public int search(int[] nums, int target) {
        
        // for(int i = 0; i<nums.length; i++) {
        //     if(nums[i] == target) {
        //         return i;
        //     }
        // }
        // return -1;
        int length = nums.length;
        int low = 0, high = length-1;
        if(length <= 0) {
            return -1;
        }
        int mid = 0;
        while(low < high) {
            mid = low + (high-low)/2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        // System.out.println("min val index = "+low);
        //mid = min value index
        
        int rotate = low;
        int left = 0;
        int right = length-1;
        while(left<=right){
            mid = left + (right-left)/2;
            int real_mid=(mid+rotate)%length;
            if(nums[real_mid] == target) {
                return real_mid;
            }
            if(nums[real_mid]<target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return -1;
        
    }
}