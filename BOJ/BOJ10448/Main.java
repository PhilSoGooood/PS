package BOJ.BOJ10448;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int result = isEureka(num);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int isEureka(int num) {
        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < num + 1; j++) {
                for (int k = 1; k < num + 1; k++) {
                    int sum = (i * (i+1) / 2) + (j * (j+1) / 2) + (k * (k+1) / 2);
                    if (sum == num) return 1;
                }
            }
        }
        return 0;
    }
}
