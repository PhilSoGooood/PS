package BOJ.BOJ12789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> numbers = Arrays.stream(br.readLine().split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		int[] order = new int[N+1];
		int count = 1;
		Deque<Integer> readyLine = new LinkedList<>();
		Stack<Integer> readySpace = new Stack<>();
		for (Integer readyNumber : numbers) {
			readyLine.addLast(readyNumber);
		}

		boolean yummy = true;

		while (!readyLine.isEmpty()) {
			int student = readyLine.pollFirst();
			if (count == student) {
			//다음 순서인 경우
				order[student] = count++;
			} else if (!readySpace.isEmpty() && readySpace.peek() > student) {
			//다음 순서는 아니지만 대기공간보다 앞 순서(작은 숫자)인 경우
				readySpace.push(student);
			} else if (!readySpace.isEmpty() && readySpace.peek() == count) {
			//다음 순서가 아니고 대기공간의 맨위 숫자가 다음 순서인경우
				order[readySpace.pop()] = count++;
				readyLine.addFirst(student);
			} else if (!readySpace.isEmpty() && readySpace.peek() < student) {
				//다음 순서도 아니고 대기 공간의 숫자보다 큰 경우 -> 종료
				yummy = false;
				break;
			} else {
				readySpace.push(student);
			}
		}
		while (yummy && !readySpace.isEmpty()) {
			int student = readySpace.pop();
			if (student != count) {
				yummy = false;
				break;
			}
			order[student] = count++;
		}
		if (yummy) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}
}
