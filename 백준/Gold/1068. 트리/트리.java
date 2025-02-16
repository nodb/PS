import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int deleteNode, root, leafCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        root = -1;
        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i; // 루트 노드 저장
            } else {
                tree[parent].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());

        // 루트 노드를 삭제하면 남는 리프 노드 없음
        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        // 부모 노드에서 삭제할 노드 제거
        removeNodeFromParent();

        // 리프 노드 개수 계산
        countLeafNodes(root);
        System.out.println(leafCount);
    }

    // 부모 노드의 자식 리스트에서 삭제할 노드 제거
    static void removeNodeFromParent() {
        for (int i = 0; i < tree.length; i++) {
            tree[i].remove((Integer) deleteNode);
        }
    }

    // DFS를 사용하여 리프 노드 개수 계산
    static void countLeafNodes(int node) {
        if (node == deleteNode) return; // 삭제된 노드면 무시

        if (tree[node].isEmpty()) {
            leafCount++;
            return;
        }

        for (int child : tree[node]) {
            countLeafNodes(child);
        }
    }
}
