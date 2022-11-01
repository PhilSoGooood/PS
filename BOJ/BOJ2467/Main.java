package BOJ.BOJ2467;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[2];
        int st = 0;
        int end = N - 1;
        int min = arr[0] + arr[N - 1];

        while (st < end) {
            int sum = arr[st] + arr[end];
            if (Math.abs(min) >= Math.abs(sum)) {
                min = sum;
                answer[0] = arr[st];
                answer[1] = arr[end];
            }
            int left = Math.abs(arr[st + 1] + arr[end]);
            int right = Math.abs(arr[st] + arr[end - 1]);
            if (left > right) {
                end--;
            } else {
                st++;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer[0] + " " + answer[1]);
        bw.flush();
        bw.close();
        br.close();
    }

}

