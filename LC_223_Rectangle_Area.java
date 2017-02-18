/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int areaA = (C-A)*(D-B);
        int areaB = (G-E)*(H-F);
        
        int left_overlap = Math.max(A, E);
        int right_overlap = Math.min(C, G);
        int top_overlap = Math.min(D, H);
        int bottom_overlap = Math.max(B,F);
        
        
        int overlap = 0;
        
        if(right_overlap > left_overlap && top_overlap > bottom_overlap) {
            overlap = (right_overlap - left_overlap)*(top_overlap - bottom_overlap);
        }
        
        return areaA+areaB-overlap;
        
        
        
    }
}