package DFS;

import java.util.Scanner;

public class DFS_14502 {
    static int [] nx = { 0,0,-1,1 };
    static int [] ny = { 1,-1,0,0 };

    static int N, M;
    static int map[][];
    static int tempMap[][];
    static int result = 0;

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        tempMap = new int[N][M];

        for ( int i = 0; i< N; i++) {
            for (int j = 0 ; j < M; j++) {
                int n = sc.nextInt();
                tempMap[i][j] = n;
                map[i][j] = n;
            }
        }

        // 울타리 치고 바이러스 퍼뜨린 후 result에 max 값 저장
        wooltariDfs(0);

        // 바이러스 퍼뜨리기

        System.out.println(result);
    }

    public static void wooltariDfs(int cnt) {

        // 울타리 개수 3이면 virus 퍼뜨린다.
        if(cnt == 3) {
            for (int i = 0; i < N; i++ ){
                for(int j = 0 ;j < M; j++) {
                    tempMap[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < N; i++ ){
                for(int j = 0 ;j < M; j++) {
                    if(tempMap[i][j] == 2) {
                        virusDfs(i,j);
                    }
                }
            }// 현재기준으로 상 / 하 / 좌 / 우로 무한히 퍼져간다.
            result = Math.max(result, getResult());
            return;
        }

        // 3개아니면 DFS
        for(int i = 0; i< N; i++ ) {
            for (int j = 0; j<M;j++) {
                // 울타리 친다.
                if ( map[i][j] == 0 ) {
                    map[i][j] = 1;
                    cnt++;
                    wooltariDfs(cnt);
                    cnt--;
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void virusDfs(int x, int y) { // 현재 x,y 기준으로 퍼져나간다.
        for (int i = 0; i < 4; i++) {
            if (x + nx[i] >= 0 && x + nx[i] < N && y + ny[i] >= 0 && y + ny[i] < M) {
                if(tempMap[x + nx[i]][y + ny[i]] == 0) {
                    tempMap[x + nx[i]][y + ny[i]] = 2;
                    virusDfs(x + nx[i], y + ny[i]);
                }
            }
        }
    }

    public static int getResult() {
        int answer=0;
        for (int i = 0 ; i<N; i++) {
            for ( int j = 0; j<M; j++) {
                if(tempMap[i][j] == 0 ) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
