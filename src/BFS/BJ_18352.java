package BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_18352 {

    static int [] minLengthFromX;
    static int N, M, K, X;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        minLengthFromX = new int[N+1];

        ArrayList<Integer> list[] = new ArrayList[N+1];
        for(int i =0; i<N+1; i++ ) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i< M; i++) {
            list[sc.nextInt()].add(sc.nextInt());
        }

        queue.add(X);
        int count = 0;

        while(queue.isEmpty() == false) {

            // 탐색 전 poll
            int n = queue.poll();
            // 인접 행렬을 이용한 탐색
            for( int i = 0; i < list[n].size(); i++) { // 갈 수 있는 도시인데
                // 아직 방문하지 않은 도시라면
                if(minLengthFromX[list[n].get(i)] == 0) {
                    minLengthFromX[list[n].get(i)] = minLengthFromX[n]+1;
                    queue.add(list[n].get(i));
                }
            }
        }

        boolean bool = false;
        for(int i = 0; i < minLengthFromX.length; i++) {
            if( minLengthFromX[i] == K ) {
                System.out.println(i);
                bool = true;
            }
        }

        if(bool == false ) System.out.println(-1);
    }
}
