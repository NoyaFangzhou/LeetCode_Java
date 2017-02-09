/*

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (n < 1 || k == 0) {
            return result;
        }
        
        add(result, new ArrayList<Integer>(), k, 1, n);
        return result;
        
        
    }
    
    private void add(List<List<Integer>> result, List<Integer> temp, int count, int start, int n ) {
        
        if(count == 0) {
            result.add(new ArrayList<Integer>(temp));
        }
        
        for(int i = start; i<=n && count > 0; i++) {
            temp.add(i);
            add(result, temp, count-1, i+1, n);
            temp.remove(temp.size()-1);
        }
        
        
        
    }
}