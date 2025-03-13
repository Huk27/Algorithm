package LeetCode.SlidinWindow;

import java.util.Deque;
import java.util.LinkedList;

/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray
containing only 1's in the resulting array.
Return 0 if there is no such subarray.



Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2,
[1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4,
[0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 */
public class LongestSubArray {
    public static int longestSubarray(int[] nums) {
        int max = 0;
        int left = 0; // 왼쪽 1의 위치
        int zeroCount = 0;

        for (int right=0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            max = Math.max(right - left, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1})); // 3
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1})); // 5
        System.out.println(longestSubarray(new int[]{1,1,1})); // 2
        System.out.println(longestSubarray(new int[]{1,0,0,0,0})); // 1
        System.out.println(longestSubarray(new int[]{0,0,0})); // 0
    }
}
