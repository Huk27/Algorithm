package BinarySearch;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class BJ_2110 {

    static int N, M;
    static int node[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        node = new int[N];

        for ( int i = 0; i < N; i++ ) {
            node[i] = sc.nextInt();
        }
        Arrays.sort(node);

        int left = 1;
        int right = node[N-1] - node[0];
        int ans = 0;
        int mid;
        int startIdx;
        int cnt;
        while ( left <= right ) {
            mid = (left + right) / 2;
            startIdx = 0;
            cnt = 1;
            for(int i = 0; i< N; i++) {
                if( node[i] - node[startIdx] >= mid) {
                    cnt++;
                    startIdx = i;
                }
            }

            if ( cnt >= M ) { // 간격 넓히기.
                ans = mid;
                left = mid + 1;
            } else { // 간격 줄이기
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
