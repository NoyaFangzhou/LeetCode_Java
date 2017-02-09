/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<String>();
        
        int length = s.length();
        
        if(length < 4 || length > 12) {
            return result;
        }
        
        getIPAddress(result, s, 1, new String());
        return result;
        
    }
    // pos means now adding which segment of IP in to the string
    private void getIPAddress(List<String> result, String s, int pos, String temp) {
        // System.out.println("s = "+s);
        if (pos == 4) {
            if (isValidIP(s.substring(0))) {
                temp += s.substring(0);
                result.add(temp);
            }
            return;
        }
        // l is the length of each IP section
        // l should at most 3 and after cutting down l chars, the rest should be at least equal to the 4-pos
        for(int i = 1; i < 4 && s.length() - i >= (4-pos); i++) {
            // System.out.println("IP section "+pos+" is " + s.substring(0, i)+ " i is "+i);
            if(isValidIP(s.substring(0, i))) {
                temp += s.substring(0, i)+".";
                // System.out.println("temp is "+ temp+"\n"+"rest section is"+s.substring(i));
                getIPAddress(result, s.substring(i), pos+1, temp);
                temp = temp.substring(0, temp.length()-i-1);
            }
        }
        
        
    }
    
    // whether is a valid IP number (0 - 255)
    private boolean isValidIP(String s) {
        // avoid empty string
        if(s.length() <= 0) {
            // System.out.println("invalid IP" + s);
            return false;
        }
        // avoid conditions like 06
        if (s.length() > 1 && s.charAt(0) == '0') {
            // System.out.println("invalid IP" + s);
            return false;
        }
        // rest conditions, should between (0-255)
        int n = Integer.parseInt(s);
        // System.out.println("valid n = "+n);
        return (n >= 0 && n < 256 );
    }

}