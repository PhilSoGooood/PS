package BOJ.BOJ13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int W = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());
        int[][] trucks = new int[N][2];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trucks[i][0] = Integer.parseInt(input[i]);
        }

        int st = 0;
        int end = 0;
        int answer = 0;
        int sumWeight = 0;

        while (st < N) {
            answer++;
            for (int i=st; i < end; i++) {
                trucks[i][1]++;
            }
            if (trucks[st][1] > W) {
                sumWeight -= trucks[st][0];
                st++;
            }
            if (end < N && sumWeight + trucks[end][0] <= L) {
                sumWeight += trucks[end][0];
                trucks[end][1] = 1;
                end++;
            }
        }
        System.out.println(answer);
    }
}
