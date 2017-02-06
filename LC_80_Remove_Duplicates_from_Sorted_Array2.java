/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        
        int i = 0;
        boolean isSecond = true;
        for (int n : nums) {
            // not duplicate or at the beginning
            if (i == 0 || n > nums[i-1]) {
                // System.out.println("isSecond = "+btos(isSecond)+" will set to true");
                nums[i++] = n;
                isSecond = true;
            }
            // duplicate only once
            else if (n == nums[i-1] && isSecond) {
                // System.out.println("isSecond = "+btos(isSecond)+" will set to false");
                nums[i++] = n;
                isSecond = false;
            }
        }
        return i;
        
    }
    
    private String btos(boolean b) {
        return b? "true" : "false";
    }
}