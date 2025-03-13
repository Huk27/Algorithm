package LeetCode.HashMapSet;

import java.util.Arrays;

/*
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character
into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.
Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.



Example 1:
Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

Example 2:
Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

Example 3:
Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"

 */
public class DetermineIfTwoStringsAreClose {
    public static boolean closeStrings(String word1, String word2) {
        int[] word1CountArr = new int[26];
        int[] word2CountArr = new int[26];
        for (char c : word1.toCharArray()) {
            word1CountArr[c - 'a'] += 1;
        }

        for (char c : word2.toCharArray()) {
            word2CountArr[c - 'a'] += 1;
        }

        // 알파벳 구성에 대한 검사
        for (int i=0; i<word1CountArr.length; i++) {
            if (word1CountArr[i] > 0 && word2CountArr[i] == 0 || word2CountArr[i] > 0 && word1CountArr[i] == 0) {
                return false;
            }
        }

        Arrays.sort(word1CountArr);
        Arrays.sort(word2CountArr);

        for (int i=0; i<word1CountArr.length; i++) {
            if (word1CountArr[i] != word2CountArr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("uau", "ssx"));
    }
}
