/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    public boolean isPalindrome(String s) {
        
        int begin = 0, end = s.length()-1;
        
        // empty string
        if (begin > end) {
            return true;
        }
        // one character only
        if (begin == end) {
            return true;
        }
        char[] schar = s.toLowerCase().toCharArray();
        // System.out.println("s lower "+s.toLowerCase());
        while(begin < end) {
            if (isValid(schar[begin]) && isValid(schar[end])) {
                if(schar[begin++] != schar[end--]) {
                    return false;
                }
            }
            else {
                if (!isValid(schar[begin])) {
                    begin ++;
                    continue;
                }
                if (!isValid(schar[end])) {
                    end --;
                    continue;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        // System.out.println(c+"is invalid");
        return false;
    }
}