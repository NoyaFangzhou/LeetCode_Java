/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if(length == 1) {
            return strs[0];
        }
        
        String new_prefix = strs[0];
        for(int i = 1; i<length; i++) {
            new_prefix = commonPrefix(new_prefix, strs[i]);
            if (new_prefix.isEmpty()) {
                return "";
            }
        }
        
        return new_prefix;
        
    }
    
    private String commonPrefix(String prefix, String str) {
        int length = 0;
        for(int i = 0; i<Math.min(prefix.length(), str.length()); i++) {
            if(prefix.charAt(i) == str.charAt(i)) {
                length ++;
            }
            else {
                break;
            }
        }
        return length == 0? "" : prefix.substring(0, length);
    }
}