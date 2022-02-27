package BOJ.BOJ1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		Map<String, Integer> neverHeardPeople = new HashMap<>();
		List<String> neverKnownPeople = new ArrayList<>();
		for(int i=0; i<N; i++){
			neverHeardPeople.put(br.readLine(), 1);
		}
		for(int i=0; i<M; i++){
			String input = br.readLine();
			if(neverHeardPeople.containsKey(input)){
				neverKnownPeople.add(input);
			}
		}
		System.out.println(neverKnownPeople.size());
		neverKnownPeople.sort(Comparator.naturalOrder());
		for (String neverKnownPerson : neverKnownPeople) {
			System.out.println(neverKnownPerson);
		}
	}
}
