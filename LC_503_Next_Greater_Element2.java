/*
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.
*/

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
         
        int length = nums.length;
        
        int[] result = new int[length];
        
        Arrays.fill(result, -1);
        
         if (length <= 1) {
            return result;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i<length*2; i++) {
            int num = nums[i%length];
            // System.out.println(num);
            while(!stack.isEmpty() && nums[stack.peek()]<num) {
                // System.out.println("assign "+num+" in "+stack.peek());
                result[stack.pop()] = num;
            }
            if (i < length) {
                // System.out.println("push");
                stack.push(i);
                // System.out.println("peek"+stack.peek());
            }
        }
        
        return result;
    }
}