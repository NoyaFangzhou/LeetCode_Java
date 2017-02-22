/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 0) {
            return s;
        }
        int length = s.length();
        int gap = numRows-2;
        char[] string = s.toCharArray();
        
        StringBuilder[] sbarray = new StringBuilder[numRows];// each string builder indicate a row 
        
        // init
        for(int i = 0; i<numRows; i++) {
            sbarray[i] = new StringBuilder();
        }
        
        int c_index = 0;
        //enumerate every char
        while (c_index < length) {
            for(int i = 0; i<numRows && c_index < length; i++) {
                sbarray[i].append(string[c_index++]);// add first element to each string builder
            }
        
            for(int i = gap; i>= 1 && c_index < length; i--) {
                sbarray[i].append(string[c_index++]);
            }
        }
        
        String result = new String();
        for(int i = 0; i<sbarray.length; i++) {
            result += sbarray[i].toString();
            
        }
        return result;
    }
}