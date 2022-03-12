package BOJ.BOJ12852;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[] result;
	public static int getIndex(int i) {
		if(Math.min(Math.min(result[i/3], result[i/2]), result[i-1]) == result[i/3]) return i/3;
		if(Math.min(Math.min(result[i/3], result[i/2]), result[i-1]) == result[i/2]) return i/2;
		return i-1;
	}

	public static int getIndex(int x, int y) {
		if((Math.min(result[x], result[y]) == result[x])) return x;
		return y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		result = new int[N + 1];
		List<Integer>[] listArr = new List[N + 1];
		listArr[0] = new ArrayList<>();
		listArr[1] = new ArrayList<>();
		listArr[1].add(1);
		for (int i = 2; i < N + 1; i++) {
			int index;
			if(i % 3 == 0 && i % 2 == 0){
				index = getIndex(i);
				result[i] = result[index] + 1;
				listArr[i] = new ArrayList<>();
				listArr[i].addAll(listArr[index]);
				listArr[i].add(i);
			} else if(i % 3 == 0){
				index = getIndex(i/3, i-1);
				result[i] = result[index] + 1;
				listArr[i] = new ArrayList<>();
				listArr[i].addAll(listArr[index]);
				listArr[i].add(i);
			} else if(i % 2 == 0){
				index = getIndex(i/2, i-1);
				result[i] = result[index] + 1;
				listArr[i] = new ArrayList<>();
				listArr[i].addAll(listArr[index]);
				listArr[i].add(i);
			} else {
				result[i] = result[i-1] + 1;
				listArr[i] = new ArrayList<>();
				listArr[i].addAll(listArr[i-1]);
				listArr[i].add(i);
			}
		}
		bw.write(result[N] + "\n");
		for(int i=listArr[N].size()-1; i>=0; i--){
			bw.write(listArr[N].get(i) + " ");
		}
		bw.flush();
		bw.close();
	}
}
