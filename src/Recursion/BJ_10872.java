package Recursion;

import java.util.Scanner;

public class BJ_10872 {

    static int [] memoization;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if( N == 0 ){
            System.out.println(1);
        } else {
            memoization = new int[N];
            System.out.println(factorial(N));
        }
    }

    public static int factorial(int N) {
        switch (N) {
            case 1:
                memoization[0]=1;
                return 1;
        }

        if(memoization[N-1] != 0) {
            return memoization[N-1];
        } else {
            memoization[N-1] = factorial(N-1)*N;
            return memoization[N-1];
        }
    }
}
