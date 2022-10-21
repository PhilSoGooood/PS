package BOJ.BOJ1920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int M = Integer.parseInt(br.readLine());
    int[] targets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(nums);
    for (int i = 0; i < M; i++) {
      bw.write(isExist(targets[i], nums) +  "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static int isExist(int target, int[] nums) {
    int st = 0;
    int end = nums.length-1;
    while (st <= end) {
      int mid = (st + end) / 2;
      if (target > nums[mid]) st = mid + 1;
      else if (target < nums[mid]) {
        end = mid - 1;
      } else {
        return 1;
      }
    }
    return 0;
  }
}
