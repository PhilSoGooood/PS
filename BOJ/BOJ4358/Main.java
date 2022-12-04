package BOJ.BOJ4358;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        float cnt = 0;
        Map<String, Integer> map = new HashMap<>();
        while (true){
            String tree = br.readLine();
            if (tree == null || tree.isEmpty()) break;
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            cnt++;
        }
        List<String> treeList = map.keySet().stream().sorted().collect(Collectors.toList());
        if (cnt != 0) {
            for (String t : treeList) {
                String ratio = String.format("%.4f", map.get(t) * 100 / cnt);
                bw.write(t + " ");
                bw.write(ratio + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
