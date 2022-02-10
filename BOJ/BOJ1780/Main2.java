package BOJ.BOJ1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static boolean check(int x, int y, int n, int[][] paper){
		for(int i=x; i< x+n; i++){
			for(int j=y; j<y+n; j++){
				if(paper[x][y] != paper[i][j])
					return false;
			}
		}
		return true;
	}
	public static void solve(int x, int y, int z, int[][] paper, int[] result){
		if(check(x, y, z, paper)){
			result[paper[x][y]+1]++;
			return;
		}

		int n = z/3;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				solve(x+i*n, y+j*n, n, paper, result);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] result = new int[3];
		solve(0, 0, N, paper, result);
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
	}
}
