import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		String name;
		TreeMap<String, Node> children;

		public Node(String name) {
			this.name = name;
			this.children = new TreeMap<>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Node root = new Node("");

		for (int i = 0; i < n; i++) {
			String path = br.readLine();
			String[] dirs = path.split("\\\\");
			Node current = root;
			for (String dir : dirs) {
				if (!current.children.containsKey(dir))
					current.children.put(dir, new Node(dir));
				current = current.children.get(dir);
			}
		}

		for (Node node : root.children.values())
			check(node, 0);
	}

	static void check(Node node, int depth) {
		if (!node.name.equals("")) {
			for (int i = 0; i < depth; i++)
				System.out.print(" ");
			System.out.println(node.name);
		}

		for (Node child : node.children.values())
			check(child, depth + 1);
	}
}
