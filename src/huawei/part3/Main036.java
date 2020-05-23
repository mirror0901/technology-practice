package huawei.part3;

import java.util.Scanner;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: TODO
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 0, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
 * Input
 * 一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * @create: 2020-05-22 01:45
 **/
public class Main036 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int[][] maze = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            //预先探测迷宫一遍,将走不通的路设置为1
            check(maze, 0, 0);
            //正式走迷宫
            System.out.println(mazePath(maze, 0, 0));
        }
    }

    private static int check(int[][] maze, int x, int y) {
        //如果是右下角的出口
        if (x == maze.length - 1 && y == maze[x].length - 1) {
            return 1;
        }
        //如果当前位置是路
        if (x < maze.length && y < maze[maze.length - 1].length && maze[x][y] == 0) {
            //如果下一步横竖都是死
            if (check(maze, x + 1, y) == -1 && check(maze, x, y + 1) == -1) {
                //本位置被封死
                maze[x][y] = 1;
                return -1;
            } else {
                return 1;
            }
        } else {
            //如果当前位置不是路
            return -1;
        }
    }

    private static String mazePath(int[][] maze, int x, int y) {
        //如果是右下角的出口，返回坐标
        if (x == maze.length - 1 && y == maze[x].length - 1) {
            return "(" + x + "," + y + ")";
        }
        //如果当前位置是路，返回坐标并且继续前进
        if (x < maze.length && y < maze[maze.length - 1].length && maze[x][y] == 0) {
            return "(" + x + "," + y + ")" + "\n" + mazePath(maze, x + 1, y) + mazePath(maze, x, y + 1);
        }
        //如果当前位置不是路，什么也不做
        else {
            return "";
        }
    }

}
