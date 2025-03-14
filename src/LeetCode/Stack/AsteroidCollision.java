package LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

/*
We are given an array asteroids of integers representing asteroids in a row.
The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size,
and the sign represents its direction (positive meaning right, negative meaning left).
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions.
If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode.
Two asteroids moving in the same direction will never meet.



Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.


Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        // 10,2,-5
        for (int i : asteroids) {
            int result = i;
            // stack에 넣고 복합호출 처리
            while(!stack.isEmpty()) {
                int peek = stack.peek();
                // 현재값이 양수일경우 그냥 넣는다.
                // 현재값이 음수일경우 stack에서 계속 빼면서, 자기보다 작은 양수를 없앤다.

                if (i < 0 && peek > 0) {
                    // 결합
                    int sum = i + peek;
                    if (sum < 0) {
                        stack.pop(); // peek 제거
                    } else if (sum > 0) {
                        result = 0;
                        break;
                    } else if (sum ==0){
                        stack.pop();
                        result = 0;
                        break;
                    }
                } else {
                    break;
                }
            }

            if (result != 0) {
                stack.push(result);
            }
        }

        // 1. Integer 배열로 변환
        Integer[] tempArray = stack.toArray(new Integer[0]);

        // 2. int[] 배열로 변환
        int[] result = Arrays.stream(tempArray).mapToInt(Integer::intValue).toArray();

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(asteroidCollision(new int[]{8,-8}));
        System.out.println(asteroidCollision(new int[]{5,10,-5}));
        System.out.println(asteroidCollision(new int[]{10,2,-5}));
//        System.out.println(asteroidCollision(new int[]{-2,-1,1,2}));
//        System.out.println(asteroidCollision(new int[]{-2,-2,-2,1}));
        System.out.println(asteroidCollision(new int[]{-2,1,-2,-2}));
    }

}
