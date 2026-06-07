/*
Rat in a Maze
Difficulty: MediumAccuracy: 35.75%Submissions: 420K+Points: 4Average Time: 25m
Consider a rat placed at position (0, 0) in an n x n square matrix maze[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

Note: Return the final result vector in lexicographically smallest order.

Examples:

Input: maze[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.
Input: maze[][] = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: DDRR and RRDD.
Constraints:
2 ≤ n ≤ 5
0 ≤ maze[i][j] ≤ 1

*/

class Solution {
    public void helper(int sr, int sc, int dr, int dc, String path, ArrayList<String> ans, int [][]maze){
        if(sr==0 || sc==0 || sr>dr || sc>dc || maze[sr][sc] == 0){
            return;
        }
        if(sr==dr && sc==dc){
            ans.add(path);
            return;
        } 
        maze[sr][sc] = 0;
        helper(sr+1, sc, dr, dc, "D", ans, maze); 
        helper(sr, sc-1, dr, dc, "L", ans, maze);  
        helper(sr, sc+1, dr, dc, "R", ans, maze);  
        helper(sr-1, sc, dr, dc, "U", ans, maze);
        maze[sr][sc] = 1;    
    }
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        int sr = 0;
        int sc = 0;
        int dr = n-1;
        int dc = n-1;
        
        ArrayList<String> ans = new ArrayList<String>();
        helper(sr, sc, dr, dc, "", ans, maze);
        return ans;
        
    }
}