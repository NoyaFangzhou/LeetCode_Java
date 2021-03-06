/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int length = str.length();
        //find the length of proper substring
        for(int i = length/2; i>0; i--) {
            if(length%i == 0) {
                int n = length/i;
                String base = str.substring(0, i);
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j<n; j++) {
                    temp.append(base);
                }
                if(temp.toString().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    //     int l = str.length();
    //     for(int i=l/2;i>=1;i--) {
    // 		if(l%i==0) {
    // 			int m = l/i;
    // 			String subS = str.substring(0,i);
    // 			StringBuilder sb = new StringBuilder();
    // 			for(int j=0;j<m;j++) {
    // 				sb.append(subS);
    // 			}
    // 			if(sb.toString().equals(str)) return true;
    // 		}
    // 	}
    // 	return false;
    }
}