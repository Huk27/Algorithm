package LeetCode.HashMapSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj)
such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements
in the same order (i.e., an equal array).



Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]


Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105
 */
public class EqualRowAndParis {

    public static int equalPairs(int[][] grid) {
        Map<String, Integer> keywordAndCount = new HashMap<>();
        for (int i=0; i<grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<grid.length; j++) {
                sb.append(grid[i][j] + ",");
            }
            keywordAndCount.put(sb.toString(), keywordAndCount.getOrDefault(sb.toString(), 0) + 1);
        }

        int sum = 0;
        for (int j=0; j<grid.length; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<grid.length; i++) {
                sb.append(grid[i][j] + ",");
            }
            sum += keywordAndCount.getOrDefault(sb.toString(), 0);
        }


        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
        System.out.println(equalPairs(new int[][]{{11,1},{1,11}}));
    }
}
