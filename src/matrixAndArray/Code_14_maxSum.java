package matrixAndArray;

/**
 * 矩阵中子矩阵最大累加和功能
 * 思路 从第一行开始
 * 例子 -90   48  78
 *      64  -40   64
 *      -81 -7    66
 *
 *  第一行开始 首先考虑第一行 -90    48   78 最大为 126
 *              加下面一行   64 -40 64  相加
 *                    =     -26  8  142  最大 150
 *               再加一行   -81  -7  66 再相加
 *                         -107 1 208  最大 209
 *               从第二行开始 重复 在和下面相加
 */
public class Code_14_maxSum {
    public int maxSum(int[][] m){
        if(m==null || m.length == 0||m[0].length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        return 0;
    }
}
