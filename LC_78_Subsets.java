/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {

    	List<List<Integer>> result = new ArrayList<List<Integer>>();

    	if (nums.length <= 0) {
    		return result;
    	}

    	backtrack(nums, result, new ArrayList<Integer>(), 0);

    	bitoperation(nums, result);
        
    }

    // backtrack solution
    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int index) {

    	result.add(new ArrayList<Integer>(temp));

    	for(int i = index; i<nums.length; i++) {
    		temp.add(nums[i]);
    		backtrack(nums, result, temp, i+1);
    		temp.remove(temp.size()-1);
    	}
    }

    // bit solution
    public void bitoperation(int[] nums, List<List<Integer>> result) {

    	int range = 1 << nums.length;

	    for(int i = 0; i<range; i++) {
	    	List<Integer> temp = new ArrayList<Integer>();
	    	// find all subset by using the number of 1s for each index in nums
	    	// 000..0 - 111...1
	    	// for example range = 0 - 8
	    	// i belongs to 0000, 0001, 0010, 0011, 0100, 0101, 0110, 0111, 1000
	    	// we can see that the number of 1 together with its index can indicate the subset element number for the set
	    	// 
	    	// by enumerate each index in j, we can get  0001, 0010, 0100
	    	// to find out all subset, we can use j as masks to find all subset elements in nums array
	    	for(int j = 0; j<nums.length; j++) {
	    		if(i & (1 << j) != 0) {
	    			temp.add(nums[j]);
	    		}
	    	}
	    	result.add(temp);
	    }
    }

}