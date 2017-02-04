/**
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 */
public class Solution {

	public void sortColors(int[] nums) {
		int length = nums.length;

		if (length <= 1) {
			return 
		}

		int head = 0, tail = length-1, i = 0;

		while (i <= tail) {
			if (nums[i] == 0) {
				nums[i] = nums[head];
				num[head] = 0;
				head ++;
			}
			if (nums[i] == 2) {
				nums[i] = nums[tail];
				nums[tail] = 2;
				tail --;
				i --;
			}
			i ++;
		}
	}
}

