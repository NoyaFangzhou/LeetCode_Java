/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	
        
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        if (ch.length <= 1) {
            return ch.length;
        }
        int start = 0;
        int max = 0;
        for(int i = 0; i<ch.length; i++) {
            // repeat
            if(map.containsKey(ch[i])) {
                start = Math.max(start, map.get(ch[i])+1);// use Max to avoid the condition when substring character is equcal to the character at the begining, so that it will trace back to the very beginning and enlarge the total substring length; eg. abba
            }
            map.put(ch[i], i);// update the index
            max = Math.max(max, i-start+1);
        }
        
        return max;
        
        
    }
}