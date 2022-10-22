package BOJ.BOJ18870;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, i);
                i++;
            }
        }
        for (int num : nums) {
            bw.write(map.get(num) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
