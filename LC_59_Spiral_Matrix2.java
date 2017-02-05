/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        if(n == 0) {
            return matrix;
        }
        // if(n == 1) {
        //     matrix[0][0] = 1;
        //     return matrix;
        // }
        int num = 1;
        int end =(int)Math.pow(n,2);
        // System.out.println("end = "+end);
        
        int rowBegin = 0, colBegin = 0;
        int colEnd = n-1, rowEnd = n-1;
        
        while(rowBegin<=rowEnd && colBegin<=colEnd && num <= end) {
            
            for(int i = colBegin; i<=colEnd; i++) {
                matrix[rowBegin][i] = num++;
            }
            rowBegin ++;
            
            for(int i = rowBegin; i<=rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd --;
            
            if(colEnd >= colBegin) {
                for(int i = colEnd; i>=colBegin; i--) {
                    matrix[rowEnd][i] = num++;
                }
            }
            rowEnd --;
            
            if(rowEnd >= rowBegin) {
                for(int i = rowEnd; i>=rowBegin; i--) {
                    matrix[i][colBegin] = num++;
                }
            }
            colBegin ++;
            
        }
        
        
        return matrix;
        
    }
}