package matrixAndArray;



import java.util.LinkedList;
import java.util.Queue;

/**
 *用一个整型矩阵matrix表示一个网络，1代表有路，0代表无路，
 * 每一个位置只要不越界，都有上下左右4个方向，求从最左上角到最右下角的最短通路值。
 * 宽度优先遍历
 *
 * 思路步骤
 * 1.开始时生成map矩阵，map[i][j]的含义是从（0，0）位置走到（i，j）位置最短的路径值。
 * 然后将左上角位置（0，0）的行坐标与列坐标放入行队列rQ和列队列cQ。
 *
 * 2不断从队列弹出一个位置（r，c），
 * 然后看这个位置的上下左右四个位置哪些在matrix上的值是1，这些都是能走的位置。
 *
 * 3.将那些能走的位置设置好各自在map中的值，即map[r][c]+1。
 * 同时将这些位置加入rQ和cQ中，用队列完成宽度优先遍历
 *
 * 4.在步骤 3 中，如果一个位置之前走过，就不要重复走，
 * 这个逻辑可以根据一个位置在map中的值来确定，比如map[i][j]！=0，就可以知道这个位置之前已经走过。
 *
 * 5.一直重复步骤2～步骤4。直到遇到右下角位置，说明已经找到终点，
 * 返回终点在map中的值即可，如果rQ和cQ已经为空都没有遇到终点位置，说明不存在这样一条路径，返回0。
 */
public class Code_23_minPathValue {
    public int minPathValue(int[][] m){
        if(m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1
            ||m[m.length - 1][m[0].length - 1] !=1){
            return 0;
        }
        int res = 0;
        //生成map矩阵 map[i][j]的含义是(0,0)到(i,j)最短的路径值
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;
        //行队列
        Queue<Integer> rQ = new LinkedList<>();
        //列队列
        Queue<Integer> cQ = new LinkedList<>();
        rQ.add(0);
        cQ.add(0);
        int r = 0;
        int c = 0;
        while(!rQ.isEmpty()){
            r = rQ.poll();
            c = cQ.poll();
            if(r == m.length - 1 && c == m[0].length - 1){
                return map[r][c];
            }
            //上
            walkTo(map[r][c], r - 1, c, m, map, rQ, cQ);
            //下
            walkTo(map[r][c], r + 1, c, m, map, rQ, cQ);
            //左
            walkTo(map[r][c], r, c - 1, m, map, rQ, cQ);
            //右
            walkTo(map[r][c], r, c + 1, m, map, rQ, cQ);
        }
        return res;
    }

    private void walkTo(int pre, int toR, int toC, int[][] m, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
        if(toR < 0 || toR == m.length || toC < 0 || toC == m[0].length
            ||m[toR][toC] != 1 || map[toR][toC] != 0){
            return;
        }
            map[toR][toC] = pre + 1;
            rQ.add(toR);
            cQ.add(toC);
    }
}
