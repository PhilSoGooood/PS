package BOJ.BOJ1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int answer = 0;
	public static boolean check(int[] selected, boolean[] isSelected){
		int count = 1;
		Queue<int[]> Q = new LinkedList<>();
		int X = selected[0] / 5;
		int Y = selected[0] % 5;
		Q.add(new int[]{X, Y});
		boolean[][] visited = new boolean[5][5];
		int[] dx =  {-1, 1, 0, 0};
		int[] dy =  {0, 0, -1, 1};
		visited[X][Y] = true;
		while (!Q.isEmpty()){
			int curX = Q.peek()[0];
			int curY = Q.peek()[1];
			Q.poll();
			for(int dir=0; dir<4; dir++){
				int newX = curX + dx[dir];
				int newY = curY + dy[dir];
				if(newX < 0 || newX > 4 || newY < 0 || newY > 4) continue;
				if(visited[newX][newY]) continue;
				if(!isSelected[newX*5 + newY]) continue;
				visited[newX][newY] = true;
				Q.add(new int[] {newX, newY});
				count++;
			}
		}
		return count == 7;
	}
	public static void select(int idx, int countStudent, int countS, boolean[] isSelected,  int[] selected, char[][] students){
		if(countStudent == 7){
			if(countS >= 4){
				if(check(selected, isSelected)){
					answer++;
				}
			}
			return;
		}
		for(int i=idx; i<25; i++){
			int isS = 0;
			isSelected[i] = true;
			selected[countStudent] = i;
			if(students[i/5][i%5] == 'S')isS = 1;
			select(i+1, countStudent+1, countS+isS, isSelected, selected, students);
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] students = new char[5][5];
		for(int i=0; i<5; i++){
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<5; j++){
				students[i][j] = arr[j];
			}
		}
		boolean[] isSelected  = new boolean[25];
		int[] selected = new int[7];
		select(0, 0, 0, isSelected, selected, students);
		System.out.println(answer);
	}
}
