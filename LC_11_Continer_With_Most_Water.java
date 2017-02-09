/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

public class Solution {
    public int maxArea(int[] height) {
        
        int length = height.length;
        int left = 0, right = length-1;
        int h = 0;
        int maxArea = 0;
        
        // for(int left = 0; left < length; left ++) {
        //     for(int right = left+1; right < length; right++) {
        //         h = Math.min(height[left], height[right]);
        //         maxArea = Math.max(maxArea, h*(right-left));
        //     }
        // }
        
        // while(left < right) {
            
        //     h = Math.min(height[left], height[right]);
        //     maxArea = Math.max(maxArea, h*(right-left));
            
        //     if (height[left] < height[right]) {
        //         left ++;
        //     }
        //     else {
        //         right --;
        //     }
            
        // }
        // return maxArea;
        
        while(left < right) {
            int hl = height[left], hh = height[right];
            h = Math.min(hl, hh);
            maxArea = Math.max(maxArea, h*(right-left));
            
            if(hl < hh) {
                while(height[left] <= hl && left < right) {
                    left ++;
                }
            }
            else {
                while(height[right] <= hh && right > 0) {
                    right --;
                }
            }
        }
        return maxArea;
        
    }
}