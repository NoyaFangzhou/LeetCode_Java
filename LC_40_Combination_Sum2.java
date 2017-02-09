/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        backtrace(candidates, target, 0, candidates.length-1, new ArrayList<Integer>(), result);
        
        return result;
        
    }
    
    private void backtrace(int[] candidates, int target, int start, int end, List<Integer> temp, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(temp));
        }
        else if(target > 0) {
            
            for(int i = start; i<=end; i++) {
                if(i>start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                int c = candidates[i];
                temp.add(c);
                backtrace(candidates, target-c, i+1, end, temp, result);
                temp.remove(temp.size()-1);
            }
            
        }
    }
}