package DP;

import java.util.Scanner;

public class BJ_1932 {

    static String [][]triangle;
    static int[] memoization;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        triangle =  new String[N][];
        sc.nextLine();

        int i = 0;
        while(sc.hasNextLine() && i < N) {
            triangle[i++] = sc.nextLine().split(" ");
        }
        if(N == 1) {
            System.out.println(triangle[0][0]);
        } else {
            for( int j = 0; j < N; j++ ) {

            }
        }
    }
}
