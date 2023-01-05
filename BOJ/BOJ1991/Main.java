package BOJ.BOJ1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Map<String, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            Node mid = findNode(parent);
            if (!left.equals(".")) {
                Node lNode = findNode(left);
                mid.setLeft(lNode);
            }
            if (!right.equals(".")) {
                Node rNode = findNode(right);
                mid.setRight(rNode);
            }
        }
        Node root = map.get("A");
        preOrderTraverse(root);
        bw.write("\n");
        inOrderTraverse(root);
        bw.write("\n");
        postOrderTraverse(root);
        bw.flush();
        bw.close();
        br.close();
    }

    private static Node findNode(String value) {
        if (!map.containsKey(value)) {
            map.put(value, new Node(value));
        }
        return map.get(value);
    }

    private static void preOrderTraverse(Node node) throws IOException {
        bw.write(node.value);
        if (node.left != null) {
            preOrderTraverse(node.left);
        }
        if (node.right != null) {
            preOrderTraverse(node.right);
        }
    }

    private static void inOrderTraverse(Node node) throws IOException {
        if (node.left != null) {
            inOrderTraverse(node.left);
        }
        bw.write(node.value);
        if (node.right != null) {
            inOrderTraverse(node.right);
        }
    }

    private static void postOrderTraverse(Node node) throws IOException {
        if (node.left != null) {
            postOrderTraverse(node.left);
        }
        if (node.right != null) {
            postOrderTraverse(node.right);
        }
        bw.write(node.value);
    }

    static class Node {

        private String value;
        private Node left;
        private Node right;

        public Node(String value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
