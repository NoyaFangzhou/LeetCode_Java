/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

public class Solution {
    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     * 
     * This method approaches the problem as one of depth-first connected
     * components search
     * @param grid, the given grid.
     * @return the number of islands.
     */
    public int numIslands(char[][] grid) {

        // Store the given grid
        // This prevents having to make copies during recursion
        // g = grid;

        // Our count to return
        int c = 0;
        
        // Dimensions of the given graph
        int y = grid.length;
        if (y == 0) return 0;
        int x = grid[0].length;
        
        // Iterate over the entire given grid
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    c++;
                }
            }
        }
        return c;
    }
    
    /**
     * Marks the given site as visited, then checks adjacent sites.
     * 
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     * 
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     * 
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private void dfs(char[][] g, int i, int j) {
        
        // Check for invalid indices and for sites that aren't land
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] != '1') return;
        
        // Mark the site as visited
        g[i][j] = '0';
        
        // Check all adjacent sites
        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j + 1);
        dfs(g, i, j - 1);
    }
}