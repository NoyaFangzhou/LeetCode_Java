/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution {
    // use binary search!
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if(length == 1) {
            return 0;
        }
        // for(int i = 0; i<length; i++) {
        //     if( i == 0 ) {
        //         if(nums[i] > nums[i+1]) {
        //             return i;
        //         }
        //     }
        //     else if( i == length-1 ) {
        //         if(nums[i] > nums[i-1]) {
        //             return i;
        //         }
        //     }
        //     else if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
        //         return i;
        //     }
        // }
        // return -1;
        int left = 0, right = length-1;
        while(right - left > 1) {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid+1]) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        //System.out.println("left = "+left +" right = "+right);
        return (left == length-1 || nums[left] > nums[left+1]) ? left : right;
    }
}