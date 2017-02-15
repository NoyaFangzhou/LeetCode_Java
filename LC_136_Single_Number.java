/*
Given an array of itegers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memeory?
*/

public class Solution {
    public int singleNumber(int[] nums) {

    	if (nums.length <= 0) {
    		return -1;
    	}

    	if (nums.length == 1) {
    		return nums[0];
    	}

    	return hashmap(nums);

    	return XORSolution(nums);
        
    }

    // solution 1:
    // using hashmap, with extra memory.
    public int hashmap(int[] nums) {

    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    	for(int i = 0; i<nums.length; i++) {
    		if(map.containsKey(nums[i])) {
    			map.put(nums[i], map.get(nums[i]+1));
    		}
    		else {
    			map.put(nums[i],1);
    		}
    	}

    	for(int key: map.keySet()) {
    		if (map.get(key) == 1) {
    			return key;
    		}
    	}

    	return -1;// not exist

    }

    // solution 2:
    // using XOR operation,
    // thus duplicated element only appears twice, using a^a = 0, we can get that 
    // doing the XOR operation for all elements in nums, the final result should be the single element.
    // No EXTRA MEMORY!
    public int XORSolution(int[] nums) {
    	int length = nums.length;
    	int single = 0;
    	for(int i = 0; i<length; i++) {
    		single ^= nums[i];
    	}
    	return single;
    }
}