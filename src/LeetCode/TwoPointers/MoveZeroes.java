package LeetCode.TwoPointers;

/*
    Given an integer array nums,
    move all 0's to the end of it
    while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.



    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Example 2:

    Input: nums = [0]
    Output: [0]


    Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return ;
        }

        int lastMinorCursor = 0;
        for (int mainCursor = 0; mainCursor < nums.length; mainCursor++) {
            if (nums[mainCursor] == 0) {
                lastMinorCursor = Math.max(mainCursor, lastMinorCursor);
                for (; lastMinorCursor < nums.length; lastMinorCursor++) {
                    if (nums[lastMinorCursor] != 0) {
                        nums[mainCursor] = nums[lastMinorCursor];
                        nums[lastMinorCursor] = 0;
                        break;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
        System.out.println(nums);
    }
}


/*
코드가 기본적으로 문제의 요구 사항을 충족하지만, 몇 가지 개선할 점이 있습니다.

문제점 및 개선사항
불필요한 내부 루프 제거

lastMinorCursor를 유지하면서 0이 아닌 요소를 찾을 때까지 이동하는 내부 for 루프가 있는데, 이는 불필요한 연산을 초래할 수 있습니다.
대신 단일 루프에서 두 개의 포인터를 활용하여 해결하는 것이 더 효율적입니다.
코드 가독성 개선

lastMinorCursor (0이 아닌 요소를 가리키는 포인터)와 mainCursor (현재 탐색 위치) 간의 역할을 좀 더 명확히 하면 가독성이 좋아집니다.
변수 이름도 보다 직관적으로 변경하면 좋습니다.
시간 복잡도 개선

현재 O(n^2)까지 갈 수 있는 구조인데, 두 개의 포인터 (Two Pointers) 방법을 활용하여 O(n)으로 최적화 가능합니다.
개선된 코드
java
복사
편집
package LeetCode.TwoPointers;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int nonZeroIndex = 0; // 0이 아닌 요소를 삽입할 위치

        // 1. 0이 아닌 모든 요소를 앞쪽으로 이동
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        // 2. 나머지 부분을 0으로 채우기
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
개선된 코드의 장점
✅ O(n) 시간 복잡도

한 번의 for 루프 (O(n))와 한 번의 while 루프 (O(n))가 있지만, 결국 O(n) + O(n) = O(n)이므로 더 빠릅니다.
기존 코드는 for 내부에서 while이 돌아가면서 최악의 경우 O(n^2)이 될 수 있었습니다.
✅ 가독성 향상

nonZeroIndex 변수를 활용하여 0이 아닌 요소를 앞으로 옮기고, 남은 공간을 0으로 채우는 방식이 훨씬 직관적입니다.
✅ 불필요한 스왑 제거

기존 코드에서는 swap 연산이 불필요하게 많았지만, 개선된 코드에서는 한 번만 각 요소를 이동시킵니다.
이제 성능이 훨씬 개선되었고, 문제의 요구 사항을 정확하게 충족하는 코드입니다! 🚀
 */
