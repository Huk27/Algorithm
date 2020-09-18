package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1300 {

    public static void main(String[] args) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        M = Integer.valueOf(br.readLine());

        int left = 1;
        int right = M;
        int ans = 0;
        while ( left <= right ) {
            int cnt = 0;
            int mid = ( left + right ) / 2;

            for (int i =0; i<N; i++) {
                cnt += Math.min(mid/(i+1), N);
            }

            if ( cnt < M) {
                left = mid+1;
            } else {
                ans = mid; right = mid-1;
            }
        }
        System.out.println(ans);
    }
}
