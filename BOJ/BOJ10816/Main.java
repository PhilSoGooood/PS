package BOJ.BOJ10816;

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
    for (int target : targets) {
      int l = leftIdx(target, nums);
      int r = rightIdx(target, nums);
      bw.write(r - l + " ");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static int leftIdx(int target, int[] nums) {
    int st = 0;
    int end = nums.length;

    while (st < end) {
      int mid = (st + end) / 2;
      if (nums[mid] >= target) end = mid;
      else st = mid + 1;
    }
    return st;
  }

  private static int rightIdx(int target, int[] nums) {
    int st = 0;
    int end = nums.length;

    while (st < end) {
      int mid = (st + end) / 2;
      if (nums[mid] <= target) st = mid + 1;
      else end = mid;
    }
    return st;
  }
}
