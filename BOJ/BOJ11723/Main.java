package BOJ.BOJ11723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static boolean[] list = new boolean[21];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	public static void add(int x){
		if(!list[x]){
			list[x] = true;
		}
	}

	public static void remove(int x){
		if(list[x]){
			list[x] = false;
		}
	}

	public static void check(int x){
		if(list[x]){
			sb.append(1 + "\n");
		} else {
			sb.append(0 + "\n");
		}
	}

	public static void toggle(int x){
		list[x] = !list[x];
	}

	public static void all(){
		Arrays.fill(list, true);
	}

	public static void empty() {
		Arrays.fill(list, false);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		for(int i=0; i<M; i++){
			String[] input = br.readLine().split(" ");
			if(input[0].equals("add")){
				add(Integer.parseInt(input[1]));
			} else if(input[0].equals("remove")) {
				remove(Integer.parseInt(input[1]));
			} else if(input[0].equals("check")) {
				check(Integer.parseInt(input[1]));
			} else if(input[0].equals("toggle")) {
				toggle(Integer.parseInt(input[1]));
			} else if(input[0].equals("all")) {
				all();
			} else {empty();}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
