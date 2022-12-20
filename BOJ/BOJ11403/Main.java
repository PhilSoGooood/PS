package BOJ.BOJ11403;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = s[j].equals("1");
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!arr[i][j] && arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j]) {
                    bw.write("1 ");
                } else {
                    bw.write("0 ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
