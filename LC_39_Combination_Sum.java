/*

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, candidates.length-1, new ArrayList<Integer>(), result);
        return result;
        
    }
    
    private void backtrack(int[] candidates, int target, int start, int end, List<Integer> temp, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if(target > 0) {
            
            for(int i = start; i<=end; i++) {
                int c = candidates[i];
                temp.add(c);
                backtrack(candidates, target-c, i, end, temp, result);
                temp.remove(temp.size()-1);
            }
            
        }
        
    }
}