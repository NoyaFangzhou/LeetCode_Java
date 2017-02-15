/*
Given an array of itegers, every element appears three times except for one. Find that single one.

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
    // count number of 1s for all elements in nums bit by bit
    // 
    // if all element appears n times, the number of 1s for each bit can satisfy one_number%3 == 0
    // however, for that single number, it cannot satisfy this equations so that if one_number%3 != 0
    // we can find this single numbr
    // 
    // this method can be extended to a general solution for find single number in an array which other elements appears n times
    // No EXTRA MEMORY!
    public int bitSolution(int[] nums) {

    	int length = nums.length;
    	int ans = 0;

    	// for each bit 
    	for(int i = 0; i<32; i++) {
    		int sum = 0;// num of 1 for each bit
    		// for each element in nums
    		for(int j = 0; j<length; j++) {
    			// find 1 for the i+1 bit
    			if (num[j] >> i) & 1 == 1) {
					sum ++;
					sum %= 3;
				}	
    		}
    		if (sum != 0) {
    			ans |= << i // restore the single element
    		}
    	}

    	return ans;
    }

    public int generalSingleNumber(int[] nums, int duplicate_time) {

    	int length = nums.length;
    	int ans = 0;

    	// for each bit 
    	for(int i = 0; i<32; i++) {
    		int sum = 0;// num of 1 for each bit
    		// for each element in nums
    		for(int j = 0; j<length; j++) {
    			// find 1 for the i+1 bit
    			if (num[j] >> i) & 1 == 1) {
					sum ++;
					sum %= duplicate_time;
				}	
    		}
    		if (sum != 0) {
    			ans |= << i // restore the single element
    		}
    	}

    	return ans;

    }
}