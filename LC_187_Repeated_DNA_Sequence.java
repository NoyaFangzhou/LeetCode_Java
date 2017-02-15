/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        int len = s.length();
        List<String> result = new ArrayList<String>();
        
        if (len < 10) {
            return result;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        char[] map = new char[26];
        char[] schar = s.toCharArray();
        // use to encode the string
        map['A'-'A'] = 0;
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        
        for(int i = 0; i<len-9; i++) {
            int code = 0;
            // encode each substring
            for(int j = i; j<i+10; j++) {
                code <<= 2;
                code |= map[schar[j] - 'A'];
            }
            // System.out.println("code = "+code);
            
            if (!set.add(code) && set2.add(code)) {
                result.add(s.substring(i, i+10));
            }
            
        }
        
        return result;
        
    }
}