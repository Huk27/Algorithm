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

    public static double findMaxAverage2(int[] nums, int k) {
        int max = 0;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+= nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(sum, max);
        }

        return (double) max / k;
    }


    public static double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = Math.max(max, sum);


        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i-k];
            max = Math.max(sum, max);
        }

        return (double) max / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage2(new int[]{1,2,3,4,5,6,7,8}, 4));
        System.out.println(findMaxAverage2(new int[]{1,12,-5,-6,50,3}, 4));

    }
}
