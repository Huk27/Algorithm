package LeetCode.Array;

import java.util.*;

/*
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order, starting with word1.
If a string is longer than the other, append the additional letters onto the end of the merged string.
Return the merged string.



Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d


Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
 */
public class Merge_Strings_Alternatively {
    static class Node {
        char value;
        long score;

        public Node(char value, long score) {
            this.value = value;
            this.score = score;
        }
    }
    public static String mergeAlternately(String word1, String word2) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingLong(p -> -p.score));
        char[] word1Arr = word1.toCharArray();
        for (int i = 0; i < word1Arr.length; i++) {
            queue.offer(new Node(word1Arr[i], Long.MAX_VALUE - (i*10)));
        }

        char[] word2Arr = word2.toCharArray();
        for (int i = 0; i < word2Arr.length; i++) {
            queue.offer(new Node(word2Arr[i], Long.MAX_VALUE - (i*10)-1));
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Node v = queue.poll();
            sb.append(v.value);
        }
        return sb.toString();
    }

    public static void main(String []args) {
        mergeAlternately("abc", "def");
    }

    /*
        코드를 보면 우선순위 큐(PriorityQueue)를 사용해서 두 단어의 문자를 번갈아가며 정렬하려고 했는데, 지금 방식은 원하는 대로 동작하지 않을 거야.

        문제점
        우선순위 큐의 정렬 방식 문제

        PriorityQueue<Node>를 Comparator.comparingLong(p -> -p.score)로 정렬했는데,
        score 값을 Long.MAX_VALUE - (i*10)처럼 설정해서 순서를 유지하려고 했어.
        그런데 문제에서 요구하는 건 두 단어에서 한 글자씩 번갈아 가며 추가하는 것이지, 정렬 기반이 아니야.
        우선순위 큐를 사용할 필요 없이 단순한 for 루프가 더 효율적이야.
        불필요한 복잡성

        Node 클래스를 만들고, score 값을 사용해서 순서를 유지하려고 했는데, 이 문제는 단순한 문자열 처리 문제야.
        불필요한 Node 객체와 우선순위 큐를 사용하면서 오히려 성능이 안 좋아질 가능성이 있어.
        문자열 길이는 최대 100이라 O(n log n) 복잡도의 우선순위 큐를 쓰는 것보다 O(n)으로 처리하는 게 더 낫겠지.
        더 좋은 해결 방법 (Two Pointers)
        간단하게 두 개의 포인터(i, j) 를 사용해서 해결할 수 있어.

        코드 개선안

        public static String mergeAlternately(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            int i = 0, j = 0;

            while (i < word1.length() || j < word2.length()) {
                if (i < word1.length()) sb.append(word1.charAt(i++));
                if (j < word2.length()) sb.append(word2.charAt(j++));
            }
            return sb.toString();
        }
     */
}
