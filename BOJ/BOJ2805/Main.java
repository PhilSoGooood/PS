package BOJ.BOJ2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[] trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(trees);
        long st = trees[N - 1];
        long en = 0;

        while (st > en) {
            long mid = (st + en + 1) / 2;
            if (count(mid, M, trees)) {
                en = mid;
            } else {
                st = mid-1;
            }
        }
        System.out.println(en);
    }

    private static boolean count(long H, int M, int[] trees) {
        long count = 0;
        for (int height : trees) {
            if (height - H < 0) {
                continue;
            }
            count += height - H;
        }
        return count >= M;
    }
}
