/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/

public class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        
        if (s.length() <= 0) {
            return result;
        }
        addPartition(result, new ArrayList<String>(), s);
        
        return result;
        
    }
    
    private void addPartition(List<List<String>> result, List<String> temp, String s) {
        
        if (s.length() == 0) {
            result.add(new ArrayList<String>(temp));
        }
        
        for(int i = 0; i<s.length(); i++) {
            if (isPalindrome(s.substring(0,i+1))) {
                temp.add(s.substring(0, i+1));
                addPartition(result, temp, s.substring(i+1));
                temp.remove(temp.size()-1);
            }
        }
        
    }
    
    
    private boolean isPalindrome(String s) {
        
        char[] schar = s.toCharArray();
        
        int length = schar.length;
        
        for(int i = 0; i<length/2; i++) {
            if(schar[i] == schar[length-1-i]) {
                continue;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}