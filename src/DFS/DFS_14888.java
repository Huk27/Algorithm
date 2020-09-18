package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DFS_14888 {
    static int MAX= Integer.MIN_VALUE;
    static int MIN= Integer.MAX_VALUE;
    static int N;
    static int[] digits;
    static int add, sub, mul, div;

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        digits = new int[N];
        String[] tempDigits = br.readLine().split(" ");
        String[] tempOperatorNumbers = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            digits[i] = Integer.valueOf(tempDigits[i]);
        }

        add = Integer.valueOf(tempOperatorNumbers[0]);
        sub = Integer.valueOf(tempOperatorNumbers[1]);
        mul = Integer.valueOf(tempOperatorNumbers[2]);
        div = Integer.valueOf(tempOperatorNumbers[3]);

        dfs(1, digits[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int count, int nowResult) {
        if( count == N ) {
            MIN = Math.min( MIN, nowResult);
            MAX = Math.max( MAX, nowResult);
        }
        else {
            if( add > 0) {
                add--;
                dfs( count+1, nowResult + digits[count]);
                add++;
            }
            if ( sub > 0 ) {
                sub--;
                dfs( count+1, nowResult - digits[count]);
                sub++;
            }
            if ( mul > 0 ) {
                mul--;
                dfs( count+1, nowResult * digits[count]);
                mul++;
            }
            if ( div > 0 ) {
                div--;
                dfs( count+1, nowResult / digits[count]);
                div++;
            }
        }
    }
}
