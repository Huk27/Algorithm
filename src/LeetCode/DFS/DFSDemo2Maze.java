package LeetCode.DFS;

/*
2D 미로(배열)에서 (0,0)에서 (N-1,M-1)로 이동할 수 있는지 확인하라.
0은 벽, 1은 이동 가능한 길이다.

    static int[][] maze = {
        {1, 1, 0, 1, 1},
        {1, 0, 1, 1, 0},
        {1, 1, 1, 0, 1},
        {0, 0, 1, 1, 1}
    };
 */
public class DFSDemo2Maze {

    static int[][] maze = {
            {1, 1, 0, 1, 1},
            {1, 0, 1, 1, 0},
            {1, 1, 1, 0, 1},
            {0, 0, 1, 1, 1}
    };

    static boolean[][] visited = new boolean[maze.length][maze[0].length];

    public static boolean dfsMaze(int x, int y) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            System.out.println("도착: (" + x + ", " + y + ")");
            return true;
        }

        if (x < 0 || y < 0 || x > maze.length-1 || y > maze[0].length-1) {
            return false;
        }

        if (visited[x][y] || maze[x][y] == 0) {
            return false;
        }

        visited[x][y] = true;
        System.out.println("방문: (" + x + ", " + y + ")");

        boolean up = dfsMaze(x-1, y);
        boolean down = dfsMaze(x+1, y);
        boolean left = dfsMaze(x, y-1);
        boolean right =dfsMaze(x, y+1);
        boolean result = left || right || down || up;
        if (!result) {
            System.out.println("백트래킹: (" + x + ", " + y + ")");
        }
        return result;
    }

    public static void main(String[] args) {
        // 3,4로 갈수 있는지ㅏㅏ
        System.out.println(dfsMaze(0, 0));
    }
}
