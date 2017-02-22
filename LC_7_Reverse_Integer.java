/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
*/

public class Solution {
    public int reverse(int x) {
        // get the sign
        int sign = x<0? -1: 1;
        
        int rev_num = 0;
        x = Math.abs(x);
        while(x != 0) {
            
            int last_num = x%10;
            int rev_num_test = rev_num*10 + last_num;
            // avoid overflow
            if ((rev_num_test - last_num)/10 != rev_num) {
                return 0;
            }
            rev_num = rev_num_test;
            x /= 10;
            
        }
        
        return sign*rev_num;
        
    }
}