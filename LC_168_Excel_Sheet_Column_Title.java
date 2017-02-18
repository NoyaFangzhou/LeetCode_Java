/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    */

    public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        if (n <= 26) {
            char c = (char)('A'+n-1);
            System.out.println(c);
            return new StringBuilder().append(c).toString();
        }
        
        int x = n/26;
        int y = n%26;
        
        if (y == 0) {
            return convertToTitle(x-1)+convertToTitle(26);
        }
        
        return convertToTitle(x)+convertToTitle(y);
        
        // simple version
        //return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
        
    }
}