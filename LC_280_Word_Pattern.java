/*

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strSet = str.split(" ");
        char[] charPattern = pattern.toCharArray();
        if(charPattern.length != strSet.length) {
            return false;
        }
        Map map = new HashMap();
        
        for(int i = 0; i<charPattern.length; i++) {
            if(!Objects.equals(map.put(strSet[i], i), map.put(charPattern[i], i))) {
                return false;
            }
        }
        return true;
    }
}