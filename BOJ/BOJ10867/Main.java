package BOJ.BOJ10867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
BOJ10867 중복 빼고 정렬하기
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++){
			set.add(Integer.parseInt(st.nextToken()));
		}
		int[] arr = new int[set.size()];
		int i=0;
		for(int num : set){
			arr[i] = num;
			i++;
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr).replace("[", "").replace("]", "").replace(",", ""));
	}
}
