package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_12015 {
    static int N, M;
    static int node[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        node = new int[N];

        for ( int i = 0; i < N; i++ ) {
            node[i] = sc.nextInt();
        }
        Arrays.sort(node);

        int left = 0;
        int right = N;
        int ans = 0;
        int mid;
        int startIdx;
        int cnt;
        while ( left <= right ) {
            mid = (left + right) / 2;
            startIdx = 0;
            cnt = 1;
            int width = 0;
            for(int i = 0; i< N; i++) {
                if( node[i] > node[startIdx]) {
                    if ( width != 0 ) {
                        if( node[i] - node[startIdx] == width) {
                                cnt++;
                                startIdx = i;
                        } else {
                            continue;
                        }
                    } else {
                        width = node[i] - node[startIdx];
                        cnt++;
                        startIdx = i;
                    }
                }
            }

            if ( cnt >= mid ) { // 간격 넓히기.
                ans = cnt;
                left = mid + 1;
            } else { // 간격 줄이기
                right = mid - 1;
            }
        }
        if( ans == 1)
            ans = 0;

        System.out.println(ans);
    }
}
