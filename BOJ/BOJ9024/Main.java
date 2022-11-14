package BOJ.BOJ9024;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int min = Integer.MAX_VALUE;
            int cnt = 0;
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(nums);
            int st = 0;
            int en = n-1;
            while (st < en) {
                int sum = nums[st] + nums[en];
                int gap = Math.abs(k - sum);
                if (gap < min) {
                    min = gap;
                    cnt = 0;
                }
                if (min == gap) cnt++;
                if (k < sum) en--;
                else st++;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
