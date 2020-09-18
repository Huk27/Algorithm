package BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2606 {
    static Queue<Integer> queue = new LinkedList<>();

    static int [] visited;
    static int N, M;
    static int network[][];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        network = new int[N][N];
        visited = new int[N];

        for ( int i = 0; i < M; i++ ) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            network[a-1][b-1]=1;
            network[b-1][a-1]=1;
        }

        int count = 0;

        queue.add(0);
        visited[0] = 1;
        while(queue.isEmpty() == false) {

            // 탐색 전 poll
            int n = queue.poll();

            // 인접 행렬을 이용한 탐색
            for( int i = 0; i < N; i++) {
                // 갈 수 있으면.
                if(network[n][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    count++;
                    visited[i] = 1;
                }
            }
        }
        System.out.println(count);
    }
}
