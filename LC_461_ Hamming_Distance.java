/*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, calculate the Hamming distance.

    Note:
    0 ≤ x, y < 231.

    Example:

    Input: x = 1, y = 4

    Output: 2

    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑

    The above arrows point to positions where the corresponding bits are different.
*/


public class Solution {
    public int hammingDistance(int x, int y) {
        if(x == y) {
            return 0;
        }
        int result = 0;
        char[] str_x = intToBitString(x);
        char[] str_y = intToBitString(y);
        
        for(int i = 0; i<32; i++) {
            if(str_x[i] == str_y[i]) {
                continue;
            }
            result ++;
            
        }
        return result;
    }
    
    private char[] intToBitString(int x) {
        int mask = 1<<31;
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i<32; i++) {
            buf.append((x & mask) == 0? '0':'1');
            x <<= 1;
        }
        return buf.toString().toCharArray();
    }
    
}