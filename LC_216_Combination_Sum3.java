/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

public class Solution {
    // backtrace algorithm
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrace(result, new ArrayList<Integer>(), k, n, 1);
        return result;
    }
    
    private void backtrace(List<List<Integer>> result, List<Integer> temp, int time, int target, int start) {
        if(target == 0 && time == 0) {
            result.add(new ArrayList<Integer>(temp));
        }
        else {
            for(int i = start; i<=9 && target>0 && time>0; i++) {
                temp.add(i);
                backtrace(result, temp, time-1, target-i, i+1);
                temp.remove(temp.size() - 1);
            }
        }
        
        
    }
    
    
}