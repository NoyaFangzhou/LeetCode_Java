/*

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".

*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            res.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        res.append(num/den);
        
        if (num%den == 0) {
            return res.toString();
        }
        
        res.append(".");
        
        num = num%den;// remove the interger part of the fraction
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        
        while (num != 0) {
            
            num *= 10;
            
            res.append(num/den); // integer part
            
            num = num%den; // reminder
            
            // System.out.println("num = "+numerator +" stringbuilder = "+res.toString()+ " reminder = "+temp);
            
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                // res.append(numerator/denominator);
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
           
        }
        
        return res.toString();
   
    }
}