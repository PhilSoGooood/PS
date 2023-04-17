package BOJ.BOJ14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int[][] GEARS = new int[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                GEARS[i][j] = Integer.parseInt(input[j]);
            }
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            boolean[] check = new boolean[4];
            String[] com = br.readLine().split(" ");
            int num = Integer.parseInt(com[0]) - 1;
            int dir = Integer.parseInt(com[1]);
            check[num] = true;
            for (int i=num-1; i>=0; i--) {
                if (GEARS[i][2] == GEARS[i+1][6]) break;
                check[i] = true;
            }

            for (int i=num+1; i < 4; i++) {
                if (GEARS[i-1][2] == GEARS[i][6]) break;
                check[i] = true;
            }
            for (int i=0; i < 4; i++) {
                if (!check[i]) continue;
                if ((i - num) % 2 == 0) rotate(dir, i);
                else rotate(-dir, i);
            }
        }
        int answer = 0;

        for (int i=0; i < 4; i++) {
            if (GEARS[i][0] == 0) continue;
            answer += Math.pow(2, i);
        }
        System.out.println(answer);
    }


    private static void rotate(int start, int num) {
        int[] gear = new int[8];
        int st = (8 - start) % 8;
        for (int i=0; i < 8; i++) {
            gear[i] = GEARS[num][st++ % 8];
        }
        GEARS[num] = gear;
    }
}
