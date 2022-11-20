package BOJ.BOJ21939;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Question> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.l == o2.l) return o1.p - o2.p;
            return o1.l - o2.l;
        });
        // 번호, 레벨
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(stringTokenizer.nextToken());
            int L = Integer.parseInt(stringTokenizer.nextToken());
            Question question = new Question(P, L);
            treeSet.add(question);
            map.put(P, L);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");
            int P = Integer.parseInt(command[1]);
            if (command[0].equals("add")) {
                int L = Integer.parseInt(command[2]);
                Question question = new Question(P, L);
                treeSet.add(question);
                map.put(P, L);
            } else if (command[0].equals("recommend")) {
                if (P == 1) {
                    bw.write(treeSet.last().p + "\n");
                } else {
                    bw.write(treeSet.first().p + "\n");
                }
            } else {
                treeSet.remove(new Question(P, map.get(P)));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Question {
        int p;
        int l;

        public Question(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
}
