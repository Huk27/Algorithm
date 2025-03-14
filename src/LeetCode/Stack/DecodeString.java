package LeetCode.Stack;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // 숫자 전체를 한 번에 읽기
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++; // 숫자 끝까지 이동
                }
                int number = Integer.parseInt(s.substring(start, i)); // 잘라서 변환
                numberStack.push(number);
                continue; // 이미 i를 증가시켰으므로 다시 루프 진행
            } else if (c == '[') {
                stringStack.push(currentString);
                currentString = new StringBuilder();
            } else if (c == ']') {
                int repeatCount = numberStack.pop();
                StringBuilder decodedPart = new StringBuilder();
                for (int j = 0; j < repeatCount; j++) {
                    decodedPart.append(currentString);
                }
                currentString = stringStack.pop().append(decodedPart);
            } else {
                currentString.append(c);
            }
            i++;
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));  // "aaabcbc"
        System.out.println(decodeString("3[a2[c]]"));   // "accaccacc"
        System.out.println(decodeString("2[abc]3[cd]ef"));  // "abcabccdcdcdef"
        System.out.println(decodeString("10[a]"));  // "aaaaaaaaaa"
    }
}
