package LeetCode.DFS;

import java.util.*;

public class DFSDemo {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        // 그래프 초기화
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6, 7));
        graph.put(4, new ArrayList<>());
        graph.put(5, new ArrayList<>());
        graph.put(6, new ArrayList<>());
        graph.put(7, new ArrayList<>());

        System.out.println("DFS 탐색 순서:");
        dfsRecursive(1);  // 1번 노드부터 시작
    }

    public static void dfsRecursive(int startNode) {
        if (visited.contains(startNode)) {
            return;
        }
        visited.add(startNode);
        System.out.print(" " + startNode);

        for (int i=0; i< graph.get(startNode).size(); i++) {
            int nextNode = graph.get(startNode).get(i);
            dfsRecursive(nextNode);
        }
    }
}