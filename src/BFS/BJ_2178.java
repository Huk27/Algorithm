package BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2178 {

    static Queue<Integer> qy = new LinkedList<>();
    static Queue<Integer> qx = new LinkedList<>();
    static Queue<Integer> qc = new LinkedList<>();

    static int [][] visited;
    static int N, M;
    static int miro[][];

    static boolean check(int y, int x) {
        if ( y>=N||y<0||x>=M||x<0) return false;

        if( visited [y][x] == 1 ) {
            return false;
        }

        if( miro[y][x] == 0) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        miro = new int[N][M];
        visited = new int[N][M];
        String [] line;
        for(int i = 0; i < N; i++ ){
            line = sc.nextLine().split("");
            for (int j=0; j < M; j++) {
                miro[i][j] = Integer.valueOf(line[j]);
            }
        }

        int count = 1;

        qy.add(0); qx.add(0); qc.add(count);
        visited[0][0] = 1;
        while(qy.isEmpty() == false) {

            // 탐색 전 poll
            int y = qy.poll();
            int x = qx.poll();
            int c = qc.poll();

            if( y == N-1 && x == M-1) {
                System.out.print(c);
                break;
            }

            // 상
            if( check(y-1, x)) {
                visited[y-1][x] = 1;
                qy.add(y-1); qx.add(x); qc.add(c+1);
            }
            // 하
            if( check(y+1, x)) {
                visited[y+1][x] = 1;
                qy.add(y+1); qx.add(x); qc.add(c+1);
            }
            // 좌
            if( check(y, x-1)) {
                visited[y][x-1] = 1;
                qy.add(y-1); qx.add(x-1); qc.add(c+1);
            }
            // 우
            if( check(y, x+1)) {
                visited[y][x+1] = 1;
                qy.add(y); qx.add(x+1); qc.add(c+1);
            }
        }
    }
}
