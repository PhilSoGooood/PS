package BOJ.BOJ1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        Jewerly[] jewerlies = new Jewerly[N];
        int[] bag = new int[K];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stk.nextToken());
            int V = Integer.parseInt(stk.nextToken());
            jewerlies[i] = new Jewerly(M, V);
        }
        Arrays.sort(jewerlies, (a, b) -> {
            if (a.weight == b.weight) return b.value - a.value;
            return a.weight - b.weight;
        });
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bag[i] = C;
        }
        Arrays.sort(bag);
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        for (int i=0; i < K; i++) {
            while (idx < N && jewerlies[idx].weight <= bag[i]) {
                pq.add(jewerlies[idx++].value);
            }
            if (pq.isEmpty()) continue;
            answer += pq.poll();
        }
        System.out.println(answer);
    }

    private static class Jewerly {
        int weight;
        int value;
        public Jewerly(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
