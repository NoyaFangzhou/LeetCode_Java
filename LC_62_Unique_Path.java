/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        
        if( m == 1 || n == 1) {
            return 1;
        }
        
        int[][] dp = new int[m][n]; //each element indicates how many path from original point to point [i][j]
        
        for(int row = 0; row<m; row++) {
            dp[row][0] = 1;
        }
        for(int col = 0; col < n; col ++) {
            dp[0][col] = 1;
        }
        
        for(int row = 1; row < m; row ++) {
            for(int col = 1; col<n; col ++) {
                dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}