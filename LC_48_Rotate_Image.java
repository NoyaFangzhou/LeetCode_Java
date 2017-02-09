/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

*/


public class Solution {
    public void rotate(int[][] matrix) {
        
        //col -> row
        //row -> col
        //reverse row
        int length = matrix[0].length;
        if (length == 1 ) {
            return;
        }
        int col = 0, row = 0;
        for(; row < length; row ++) {
            for(col = row; col < length; col ++) {
                swap(matrix, row, col, col, row);
            }
            // System.out.println("Matrix after swap: \n"+toString(matrix[row]));
            reverse(matrix[row]);
            // System.out.println("Matrix after reverse: \n" + toString(matrix[row]));
        }
        
        
    }
    
    private void reverse(int[] nums) {
        int length = nums.length;
        for(int i = 0; i<length/2; i++) {
            int temp = nums[i];
            nums[i] = nums[length-i-1];
            nums[length-i-1] = temp;
        }
    }
    
    private void swap(int[][] matrix, int colx, int rowx, int coly, int rowy) {
        int temp = matrix[rowx][colx];
        matrix[rowx][colx] = matrix[rowy][coly];
        matrix[rowy][coly] = temp;
    }
    
    private String toString(int[] nums) {
        String s = "";
        for(int n : nums) {
            s += n + " ";
        }
        return s;
    }
}