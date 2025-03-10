package LeetCode.SlidinWindow;

/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k
that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000

Constraints:

n == nums.lengthk
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */
public class MaxAverageSubArray1 {

    public static double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for (int i=0; i<=nums.length - k; i++) {
            int sum =0;
            for (int j=0; j<k; j++) {
                sum += nums[i+j];
            }

            max = Math.max(sum, max);
        }

        return (double) max /k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
