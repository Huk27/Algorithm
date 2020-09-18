package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_10816 {
    static int N, M;
    static int node[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        node = new int[N];

        String cardList[] = br.readLine().split(" ");
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.valueOf(cardList[i]);
            if (!hashMap.containsKey(tmp)) hashMap.put(tmp, 1);
            else hashMap.put(tmp, hashMap.get(tmp)+1);
        }

        M = Integer.valueOf(br.readLine());
        String targetList[] = br.readLine().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < M; j++) {
            int tmp = Integer.valueOf(targetList[j]);
            if(hashMap.containsKey(tmp)) stringBuilder.append(hashMap.get(tmp));
            else stringBuilder.append("0");

            if(j != M-1) {
                stringBuilder.append(" ");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
