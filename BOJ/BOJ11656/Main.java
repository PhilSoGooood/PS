package BOJ.BOJ11656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// BOJ11656 접미사 배열
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		String[] arr = new String[input.length()];
		for(int i=0; i<input.length(); i++){
			arr[i] = input.substring(i);
		}
		Arrays.sort(arr);
		for(String str : arr){
			bw.write(str + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
