package BOJ.BOJ3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j);
            }
            max = Math.max(checkRow(i), max);
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(checkCol(i), max);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && arr[i][j] != arr[i][j + 1]) {
                    swap(i, j, i, j+1);
                    max = Math.max(checkRow(i), max);
                    max = Math.max(checkCol(j), max);
                    max = Math.max(checkCol(j+1), max);
                    swap(i, j, i, j+1);
                }

                if (i + 1 < N && arr[i][j] != arr[i+1][j]) {
                    swap(i, j, i+1, j);
                    max = Math.max(checkRow(i), max);
                    max = Math.max(checkRow(i+1), max);
                    max = Math.max(checkCol(j), max);
                    swap(i, j, i+1, j);
                }
            }
        }
        System.out.println(max);
    }

    private static int checkRow(int x) {
        int tmp = 1;
        int result = 1;

        char candy = arr[x][0];
        for (int i = 1; i < N; i++) {
            if (arr[x][i] != candy) {
                candy = arr[x][i];
                result = Math.max(result, tmp);
                tmp = 1;
            } else {
                tmp++;
            }
        }
        return Math.max(result, tmp);
    }

    private static int checkCol(int y) {
        int tmp = 1;
        int result = 1;

        char candy = arr[0][y];
        for (int i = 1; i < N; i++) {
            if (arr[i][y] != candy) {
                candy = arr[i][y];
                result = Math.max(result, tmp);
                tmp = 1;
            } else {
                tmp++;
            }
        }
        return Math.max(result, tmp);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
}
