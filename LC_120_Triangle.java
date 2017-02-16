/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int sz = triangle.size();
/* the basic graph for this solution is:

we create a int[] result to represent the min value for each cell at each level

it basicly looks like this: suppose we have a triangle with height 4:
    ---
    |0|
    -----
    |0|0|
    -------
    |0|0|0|
    ---------
    |0|0|0|0|
    -----------
    |0|0|0|0|0|
    -----------
we begin enumerate each level from bottom to top, and then enumerate each element within the level.
For each element, the min sum path should be its value + the min value of its two adjacent value in the next level.
for example, when we judging min path for bottom level, it stay static because there's no lower level
for level 3, we calculate 6+min(4,1) = 6+1 = 7, so after we reach number 6, the +1 to get the min sum;

so, it will be:
    ---
    |11(2+9)|
    -----
    |9(3+6)|10(4+6)|
    -------
    |7(6+1)|6(5+1)|10(7+3)|
    ---------
    |4|1|8|3|
    -----------
    |0|0|0|0|0|
    -----------


*/
        int[] results = new int[sz+1];
    
        for(int i=sz-1; i>=0; i--) {
            List<Integer> tmp = triangle.get(i);
            
            for(int j=0; j<tmp.size(); j++) {
                results[j] = Math.min(results[j], results[j+1]) + tmp.get(j);
            }
        }
        return results[0];
    }

}