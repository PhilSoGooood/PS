package LeetCode.number_of_islands;

class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                ans++;
                dfs(i, j, grid);
            }
        }
        return ans;
    }

    private void dfs(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[0].length) return;
        if (grid[x][y] == '0') return;
        grid[x][y] = '0';

        dfs(x-1, y, grid);
        dfs(x+1, y, grid);
        dfs(x, y-1, grid);
        dfs(x, y+1, grid);
    }
}
