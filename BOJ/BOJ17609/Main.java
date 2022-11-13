package BOJ.BOJ17609;

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

        for (int tc = 0; tc < T; tc++) {
            String input = br.readLine();
            int result = Math.min(isPalindrome1(input), isPalindrome2(input));
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    private static int isPalindrome1(String input) {
        int st = 0;
        int en = input.length() - 1;
        boolean flag = false;

        while (st < en) {
            if (input.charAt(st) == input.charAt(en)) {
                st++;
                en--;
                continue;
            }
            if (!flag && en - st > 1 && input.charAt(st) == input.charAt(en - 1)) {
                flag = true;
                st++;
                en-=2;
                continue;
            }
            return 2;
        }
        if (flag) return 1;
        return 0;
    }

    private static int isPalindrome2(String input) {
        int st = 0;
        int en = input.length() - 1;
        boolean flag = false;

        while (st < en) {
            if (input.charAt(st) == input.charAt(en)) {
                st++;
                en--;
                continue;
            }
            if (!flag && en - st > 1 && input.charAt(st+1) == input.charAt(en)) {
                flag = true;
                st+=2;
                en--;
                continue;
            }
            return 2;
        }
        if (flag) return 1;
        return 0;
    }
}
