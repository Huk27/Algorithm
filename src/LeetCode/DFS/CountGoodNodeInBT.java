package LeetCode.DFS;

/*
Given a binary tree root, a node X in the tree is named good
if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.


Example 2:
Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

Example 3:
Input: root = [1]
Output: 1
Explanation: Root is considered as good.

Constraints:
The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4].
 */

// 루트에서 해당 노드까지 경로에서, 해당 노드가 최대값인 개수

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CountGoodNodeInBT {

    static int count = 0;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    static TreeNode buildTreeNode(Integer[] input, int index) {
        if (input == null) {
            return null;
        }

        TreeNode treeNode;
        if (input[index] == null) {
            treeNode = null;
        } else {
            treeNode = new TreeNode(input[index]);
        }

        int leftNodeIndex = 2*index + 1;
        int rightNodeIndex = 2*index + 2;
        if (rightNodeIndex <= input.length) {
            treeNode.left = buildTreeNode(input, leftNodeIndex);
            treeNode.right = buildTreeNode(input, rightNodeIndex);
        }

        return treeNode;
    }

    public static int goodNodes(TreeNode root) {
        // 모든 경로를 탐색하면서, 현재노드가 경로중에 최대인지 아닌지 판단하는 로직
        count = 0;
        dfs(root, new ArrayList<>());
        return count;
    }

    public static void dfs(TreeNode treeNode, List<Integer> visited) {
        if (treeNode == null) {
            return ;
        }

        Integer curVal = treeNode.val;
        visited.add(curVal);

        if (curVal.equals(Collections.max(visited))) {
            count++;
        }

        dfs(treeNode.left, visited);
        dfs(treeNode.right, visited);

        visited.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = buildTreeNode(new Integer[]{3,1,4,3,null,1,5}, 0);
        TreeNode root2 = buildTreeNode(new Integer[]{3,3,null,4,2}, 0);
        System.out.println(goodNodes(root));
        System.out.println(goodNodes(root2));
    }
}

/*
피드백 정리: 경로를 계속 전달하는 방법 (백트래킹)
기존 리스트를 재사용하는 이유

새로운 리스트를 매번 생성하는 대신, 기존 리스트를 재사용하면서 경로 정보를 전달하면 메모리 절약이 가능하고 효율적입니다.
DFS 탐색 중 경로를 저장하고, 자식 노드를 탐색한 후 백트래킹을 통해 원상복구 하여, 리스트가 다른 재귀 호출에 영향을 미치지 않도록 합니다.
백트래킹 원리

경로에 현재 노드를 추가하고, 자식 노드를 탐색한 후 현재 노드를 경로에서 제거합니다. 이를 통해 자식 노드를 탐색한 후 다시 돌아가면서 경로를 원래 상태로 되돌립니다.
백트래킹 방식

각 DFS 호출에서는 동일한 path 객체를 사용하고, 탐색이 끝나면 원상복구하여 다른 경로에 영향을 주지 않도록 합니다.
path.remove(path.size() - 1)를 사용하여 백트래킹을 적용합니다.
예시 코드
java
복사
편집
private static void dfs(TreeNode node, List<Integer> path) {
    if (node == null) return;

    // 1️⃣ 현재 노드 추가
    path.add(node.val);

    // 2️⃣ 왼쪽, 오른쪽 자식 노드 탐색
    dfs(node.left, path);
    dfs(node.right, path);

    // 3️⃣ 백트래킹: 탐색 후 경로에서 현재 노드 제거
    path.remove(path.size() - 1);
}
이 방식의 장점
메모리 절약: 매번 새로운 리스트를 생성하지 않고, 기존 리스트를 재사용하여 경로를 전달합니다.
백트래킹: 자식 노드를 탐색한 후, 경로에서 현재 노드를 제거하여 다음 탐색에 영향을 주지 않음.
리스트를 공유: path는 동일한 객체를 사용하여 경로를 공유하고, 탐색 후 리스트를 원래 상태로 되돌릴 수 있음.
결론
리스트를 계속 전달해야 하는 경우, 백트래킹을 활용하여 경로를 수정하고 원상복구하는 방식이 가장 효율적입니다.
경로를 계속 전달하면서도 메모리 낭비를 줄이고, 탐색 후에는 안전하게 원래 상태로 되돌리는 방법이 효율적이고 안전한 방식입니다.

 */