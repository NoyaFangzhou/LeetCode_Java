/*
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
1. All elements in nums1 and nums2 are unique.
2. The length of both nums1 and nums2 would not exceed 1000.
*/

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        
        int nlen = nums.length;
        int flen = findNums.length;
        int[] result = new int[flen];
        if (flen > nlen || flen == 0 || nlen == 0) {
            return result;
        }
    
    
        for(int i = 0; i<flen; i++) {
            // target number
            int n = findNums[i];
            // find n in nums array
            boolean findNum = false;
            for(int j = 0; j<nlen; j++) {
                if (nums[j] == n) {
                    findNum = true;
                    boolean findLarger = false;
                    // find the first number that higher than n
                    for(int k = j; k<nlen; k++) {
                        if (nums[k] > n) {
                            result[i] = nums[k];
                            findLarger = true;
                            break;
                        }
                    }// end k
                    if (!findLarger) {
                        result[i] = -1;
                    }
                    break;
                }// end if
            }// end j
            if (!findNum) {
                result[i] = -1;
            }
            
        }
        return result;
        
    }
}