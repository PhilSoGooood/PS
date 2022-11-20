package BOJ.BOJ16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(stk.nextToken());
        int B = Integer.parseInt(stk.nextToken());

        int cnt = 1;
        while (A < B) {
            if (B % 2 == 0) B /= 2;
            else if (B % 10 == 1) B /= 10;
            else break;
            cnt++;
        }
        if (A == B) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
