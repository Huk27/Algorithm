package LeetCode.Array;

/*
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u',
and they can appear in both lower and upper cases, more than once.


Example 1:
Input: s = "IceCreAm"
Output: "AceCreIm"

Explanation:
The vowels in s are ['I', 'e', 'e', 'A'].
On reversing the vowels, s becomes "AceCreIm".

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ReverseVowelsofString {

    public static String reverseVowels(String s) {
        Set<Character> vowelSet = Set.of('A','a','E','e','I','i','O','o','U','u');
        Stack<Character> vowelStack = new Stack<>();
        List<Integer> vowelIdx = new ArrayList<>();

        int idx = 0;
        char[] inputCharArr = s.toCharArray();
        for (char c : inputCharArr) {
            if (vowelSet.contains(c)) {
                vowelStack.push(c);
                vowelIdx.add(idx);
            }
            idx++;
        }

        for (int savedIdx : vowelIdx) {
            inputCharArr[savedIdx] = vowelStack.pop();
        }

        return new String(inputCharArr);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
}


/*
📌 개선점
1. Stack을 사용하지 않고 더 간단하게 구현 가능
**Deque**나 **ArrayList**를 활용하여 모음을 역순으로 처리할 수 있음.
Stack을 사용하여 LIFO(Last In First Out) 방식으로 처리하는 것보다는 모음 인덱스만 관리하고 뒤에서부터 대체하는 방식이 더 직관적이고 성능이 좋을 수 있음.
2. vowelIdx를 사용하지 않고 인덱스만 사용해 직접 대체
모음의 인덱스를 저장하는 대신, 두 개의 포인터를 사용하여 양쪽에서 동시에 모음을 찾아 교환하는 방법을 사용할 수 있음.
이렇게 하면 vowelIdx 리스트를 관리할 필요가 없어 코드가 간결해짐.

📌 개선된 코드 (효율성 강화)
import java.util.*;

public class ReverseVowelsofString {
    public static String reverseVowels(String s) {
        Set<Character> vowelSet = Set.of('A','a','E','e','I','i','O','o','U','u');
        char[] inputCharArr = s.toCharArray();

        int left = 0, right = inputCharArr.length - 1;

        while (left < right) {
            // 왼쪽 포인터가 모음이 아닐 경우, 오른쪽으로 이동
            while (left < right && !vowelSet.contains(inputCharArr[left])) {
                left++;
            }

            // 오른쪽 포인터가 모음이 아닐 경우, 왼쪽으로 이동
            while (left < right && !vowelSet.contains(inputCharArr[right])) {
                right--;
            }

            // 모음이 있을 경우 교환
            char temp = inputCharArr[left];
            inputCharArr[left] = inputCharArr[right];
            inputCharArr[right] = temp;

            // 포인터 이동
            left++;
            right--;
        }

        return new String(inputCharArr);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));  // Output: "AceCreIm"
    }
}
    📌 개선된 코드 설명
    두 포인터 방식 (Two-pointer technique):

    left 포인터는 문자열의 시작에서부터, right 포인터는 끝에서부터 모음을 찾아 교환해.
    양쪽에서 동시에 진행하므로 불필요한 스택이나 인덱스 리스트를 사용하지 않아도 돼.
    vowelSet.contains()로 모음 체크:

    Set을 사용하여 모음인지 빠르게 확인할 수 있음.
    모음 교환:

    왼쪽과 오른쪽에서 모음이 있을 경우에만 교환하고, 이후 포인터를 이동시켜 계속해서 교환을 진행.
    📌 최적화
    공간 복잡도:
    기존의 Stack과 List를 사용하지 않으므로 O(1) 공간 복잡도.
    시간 복잡도:
    O(N)으로 한 번의 순회로 처리 가능.
    읽기 쉬운 코드:
    코드가 간결하고 직관적으로 변경되어, 유지보수가 용이함.

 */
