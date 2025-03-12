package LeetCode.SlidinWindow;

import java.util.Deque;
import java.util.LinkedList;

/*
    Given a binary array nums and an integer k,
    return the maximum number of consecutive 1's in the array
    if you can flip at most k 0's.

    Example 1:

    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

    Example 2:

    Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
    Output: 10
    Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


    Constraints:

    1 <= nums.length <= 105
    nums[i] is either 0 or 1.
    0 <= k <= nums.length
 */
public class MaxConsecutiveOnes {

    public static int longestOnes(int[] nums, int k) {
        int maxLen = 0;

        // 제일 첫번째 flip한 0의 위치
        int left = 0;
        int zeroCount = 0;
        Deque<Integer> flipIndices = new LinkedList<>();

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                flipIndices.add(right);
                zeroCount++;
            }

            if (zeroCount > k) {
                left = flipIndices.poll() + 1;
                zeroCount--;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)); // Output: 6
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3)); // Output: 10
    }
}
