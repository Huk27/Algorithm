package LeetCode.SlidinWindow;

import java.util.Set;

/*
Given a string s and an integer k,
return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
 */
public class MaximumNumberOfVowels {
    public static int maxVowels(String s, int k) {

        int max = Integer.MIN_VALUE;
        int vowelCount = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }

        max = Math.max(vowelCount, max);

        for (int i = k; i < s.length(); i++) {
            int prev = isVowel(s.charAt(i-k)) ? 1 : 0;
            int cursor = isVowel(s.charAt(i)) ? 1 : 0;
            vowelCount = vowelCount - prev + cursor;
            max = Math.max(vowelCount, max);
        }

        return max;
    }

    public static boolean isVowel(Character c) {
        Set<Character> vowles = Set.of('a','e','i','o','u');
        return  vowles.contains(c);
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3));
    }
}


/*
🔍 코드 리뷰 및 개선점
1️⃣ max 초기값을 Integer.MIN_VALUE로 설정한 부분
java
복사
편집
int max = Integer.MIN_VALUE;
max는 최대 모음 개수를 저장하는 변수입니다.
하지만, 최소값으로 Integer.MIN_VALUE를 사용하면 불필요한 비교가 발생할 수 있습니다.
max의 초기값을 0으로 설정하는 것이 더 적절합니다.
✅ 개선 코드

java
복사
편집
int max = 0;
2️⃣ Set<Character>를 정적 필드로 변경
java
복사
편집
public static boolean isVowel(Character c) {
    Set<Character> vowles = Set.of('a','e','i','o','u');
    return  vowles.contains(c);
}
현재 isVowel 메서드는 호출될 때마다 새로운 Set 객체를 생성합니다.
이는 성능 측면에서 불필요한 메모리 할당을 초래합니다.
따라서, Set을 클래스의 static 필드로 변경하면 성능이 향상됩니다.
✅ 개선 코드

java
복사
편집
private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

public static boolean isVowel(Character c) {
    return VOWELS.contains(c);
}
3️⃣ 첫 번째 윈도우(k 길이) 합을 계산한 후 max 갱신을 중복 처리한 부분
java
복사
편집
max = Math.max(vowelCount, max);
첫 번째 윈도우를 설정하는 for 루프가 끝난 후 한 번만 max = vowelCount;로 설정하면 불필요한 Math.max() 연산을 제거할 수 있습니다.
✅ 개선 코드

java
복사
편집
max = vowelCount;


package LeetCode.SlidinWindow;

import java.util.Set;

public class MaximumNumberOfVowels {

    // ✅ Set을 static final 변수로 선언하여 메모리 사용 최적화
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public static int maxVowels(String s, int k) {
        int max = 0;
        int vowelCount = 0;

        // ✅ 첫 번째 윈도우 초기화
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }
        max = vowelCount;

        // ✅ 슬라이딩 윈도우 시작
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) vowelCount--; // 왼쪽 끝 문자 제거
            if (isVowel(s.charAt(i))) vowelCount++; // 오른쪽 새 문자 추가
            max = Math.max(vowelCount, max);
        }

        return max;
    }

    public static boolean isVowel(Character c) {
        return VOWELS.contains(c);
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("leetcode", 3)); // Expected Output: 2
    }
}
 */
