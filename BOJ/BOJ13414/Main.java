package BOJ.BOJ13414;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < L; i++) {
            String student = br.readLine();
            map.remove(student);
            map.put(student, student);
        }
        List<String> list = new ArrayList<>(map.keySet());
        for (int i = 0; i <  Math.min(K, list.size()); i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
