package DP;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2579 {

    static int n;
    static int steps[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        steps = new int[n];
        dp = new int[n];
        for ( int i = 0; i<n; i++) {
            steps[i] = Integer.valueOf(br.readLine());
        }

        if( n >= 3) {
            dp[0] = steps[0];
            dp[1] = steps[0] + steps[1];
            dp[2] = Math.max(steps[0] + steps[2], steps[1]+steps[2]);
            for(int i=3;i<n;i++) {
                dp[i] = Math.max(dp[i-2] + steps[i], dp[i-3] + steps[i] + steps[i-1]);
            }
            System.out.println(dp[n-1]);
        } else if (n==2) {
            System.out.println(steps[0] + steps[1]);
        } else if ( n== 1) {
            System.out.println(steps[0]);
        }
    }
}
