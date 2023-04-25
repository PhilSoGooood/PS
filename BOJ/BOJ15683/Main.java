package BOJ.BOJ15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[][] map;
    private static boolean[][] board;
    private static List<int[]> cctvs = new ArrayList<>();
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        map = new int[N][M];
        board = new boolean[N][M];

        for (int i=0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0; j < M; j++) {
                int num = Integer.parseInt(input[j]);
                map[i][j] = num;
                if (num != 0) board[i][j] = true;
                if (0 < num && num < 6) cctvs.add(new int[] {i, j});
            }
        }
        btk(0);
        System.out.println(answer);
    }

    private static void btk(int cur) {
        if (cur == cctvs.size()) {
            answer = Math.min(answer, count());
            return;
        }

        int[] location = cctvs.get(cur);
        int x = location[0];
        int y = location[1];

        int cctv = map[x][y];

        if (cctv == 1) {
            check1(x, y, cur);
        } else if (cctv == 2) {
            check2(x, y, cur);
        } else if (cctv == 3) {
            check3(x, y, cur);
        } else if (cctv == 4) {
            check4(x, y, cur);
        } else {
            check5(x, y, cur);
        }
    }

    private static int count() {
        int result = 0;
        for (int i=0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!board[i][j]) result++;
            }
        }
        return result;
    }

    private static void check1(int x, int y, int cur) {
        List<int[]> up = checkUp(x, y);
        btk(cur + 1);
        restore(up);
        List<int[]> right = checkRight(x, y);
        btk(cur + 1);
        restore(right);
        List<int[]> down = checkDown(x, y);
        btk(cur + 1);
        restore(down);
        List<int[]> left = checkLeft(x, y);
        btk(cur + 1);
        restore(left);
    }

    private static void check2(int x, int y, int cur) {
        List<int[]> up = checkUp(x, y);
        List<int[]> down = checkDown(x, y);
        btk(cur + 1);
        restore(up);
        restore(down);
        List<int[]> left = checkLeft(x, y);
        List<int[]> right = checkRight(x, y);
        btk(cur + 1);
        restore(left);
        restore(right);
    }

    private static void check3(int x, int y, int cur) {
        List<int[]> up = checkUp(x, y);
        List<int[]> right = checkRight(x, y);
        btk(cur + 1);
        restore(up);
        List<int[]> down = checkDown(x, y);
        btk(cur + 1);
        restore(right);
        List<int[]> left = checkLeft(x, y);
        btk(cur + 1);
        restore(down);
        up = checkUp(x, y);
        btk(cur + 1);
        restore(left);
        restore(up);
    }

    private static void check4(int x, int y, int cur) {
        List<int[]> left = checkLeft(x, y);
        List<int[]> up = checkUp(x, y);
        List<int[]> right = checkRight(x, y);
        btk(cur + 1);
        restore(left);
        List<int[]> down = checkDown(x, y);
        btk(cur + 1);
        restore(up);
        left = checkLeft(x, y);
        btk(cur + 1);
        restore(right);
        up = checkUp(x, y);
        btk(cur + 1);
        restore(down);
        restore(left);
        restore(up);
    }

    private static void check5(int x, int y, int cur) {
        List<int[]> left = checkLeft(x, y);
        List<int[]> up = checkUp(x, y);
        List<int[]> right = checkRight(x, y);
        List<int[]> down = checkDown(x, y);
        btk(cur + 1);
        restore(down);
        restore(left);
        restore(up);
        restore(right);
    }

    private static List<int[]> checkUp(int curX, int curY) {
        List<int[]> list = new ArrayList<>();
        for (int i=curX-1; i >=0; i--) {
            if (map[i][curY] == 6) break;
            if (!board[i][curY]) {
                board[i][curY] = true;
                list.add(new int[]{i, curY});
            }
        }
        return list;
    }

    private static List<int[]> checkDown(int curX, int curY) {
        List<int[]> list = new ArrayList<>();
        for (int i=curX+1; i < map.length; i++) {
            if (map[i][curY] == 6) break;
            if (!board[i][curY]) {
                board[i][curY] = true;
                list.add(new int[]{i, curY});
            }
        }
        return list;
    }

    private static List<int[]> checkLeft(int curX, int curY) {
        List<int[]> list = new ArrayList<>();
        for (int i=curY-1; i >= 0; i--) {
            if (map[curX][i] == 6) break;
            if (!board[curX][i]) {
                board[curX][i] = true;
                list.add(new int[]{curX, i});
            }
        }
        return list;
    }

    private static List<int[]> checkRight(int curX, int curY) {
        List<int[]> list = new ArrayList<>();
        for (int i=curY+1; i < map[0].length; i++) {
            if (map[curX][i] == 6) break;
            if (!board[curX][i]) {
                board[curX][i] = true;
                list.add(new int[]{curX, i});
            }
        }
        return list;
    }

    private static void restore(List<int[]> list) {
        for (int[] view : list) {
            int x = view[0];
            int y = view[1];
            board[x][y] = false;
        }
    }
}
