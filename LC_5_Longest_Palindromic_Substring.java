/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/

public class Solution {
    public String longestPalindrome(String s) {
        
        int length = s.length();
        
        if(length <= 1) {
            return s;
        }
        
        String result = "";
        int longLength = 0;
        for(int i = 0; i<length; i++) {
            
            if(isPalindromic(s, i-longLength-1, i)) {
                result = s.substring(i-longLength-1, i+1);
                longLength += 2;
            }
            else if(isPalindromic(s, i-longLength, i)) {
                result = s.substring(i-longLength, i+1);
                longLength += 1;
            }
        }
        
        return result;
        
    }
    
    private boolean isPalindromic(String s, int start, int end) {
        if (start < 0 || start > end) {
            return false;
        }
        
        char[] ch = s.toCharArray();
        
        while (start < end) {
            if(ch[start++] != ch[end--]) {
                return false;
            }
        }
        return true;
    }
    
    
}