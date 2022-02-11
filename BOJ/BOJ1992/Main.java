package BOJ.BOJ1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static boolean check(int x, int y, int n, int[][] video){
		for(int i=x; i<x+n; i++){
			for(int j=y; j<y+n; j++){
				if(video[x][y] != video[i][j])
					return false;
			}
		}
		return true;
	}
	public static void quadTree(int x, int y, int z, int[][] video, StringBuilder stringBuilder){
		if(check(x, y, z, video)){
			stringBuilder.append(video[x][y]);
			return ;
		}
		else if(z == 2){
			stringBuilder.append("(");
			for(int i=x; i<x+z; i++){
				for(int j=y; j<y+z; j++){
					stringBuilder.append(video[i][j]);
				}
			}
			stringBuilder.append(")");
			return;
		}
		int n = z/2;
		stringBuilder.append("(");
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				quadTree(x+n*i, y+n*j, n, video, stringBuilder);
			}
		}
		stringBuilder.append(")");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		int[][] video = new int[N][N];
		for(int i=0; i<N; i++){
			String[] numbers = br.readLine().split("");
			for(int j=0; j<N; j++){
				video[i][j] = Integer.parseInt(numbers[j]);
			}
		}
		quadTree(0, 0, N, video, stringBuilder);
		System.out.println(stringBuilder.toString());
	}
}
