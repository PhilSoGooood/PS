package BOJ.BOJ16496;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        PriorityQueue<String> pq = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));

        Collections.addAll(pq, input);

        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        String answer = sb.toString();
        if (answer.charAt(0) == '0') {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
}
