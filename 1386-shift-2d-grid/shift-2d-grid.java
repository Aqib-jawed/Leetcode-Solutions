class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int size = rows * cols;

        k %= size;

        int[][] result = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int current = r * cols + c;
                int next = (current + k) % size;

                result[next / cols][next % cols] = grid[r][c];
            }
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int[] row : result) {
            List<Integer> list = new ArrayList<>();
            for (int value : row) {
                list.add(value);
            }
            answer.add(list);
        }

        return answer;
    }
}