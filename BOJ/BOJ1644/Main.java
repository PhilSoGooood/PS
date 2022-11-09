package BOJ.BOJ1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < N + 1; i++) {
            if (!isPrime[i]) continue;
            list.add(i);
            for (int j = 2 * i; j < N + 1; j += i) {
                isPrime[j] = false;
            }
        }
        Integer[] primes = list.toArray(Integer[]::new);
        int cnt = 0;
        int sum = 0;
        int en = 0;
        for (int st = 0; st < primes.length; st++) {
            while (en < primes.length && sum < N) {
                sum += primes[en];
                en++;
            }
            if (sum == N) cnt++;
            sum -= primes[st];
        }
        System.out.println(cnt);
    }
}
