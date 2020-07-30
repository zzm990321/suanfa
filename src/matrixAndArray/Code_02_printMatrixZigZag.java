package matrixAndArray;

/**
 * 之字形打印矩阵 难度 一
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11，8，12
 */
public class Code_02_printMatrixZigZag {
    public void printMatrixZigZag(int[][] matrix){
        //两个起点一个先往左再往下 另一个先往下再往右
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        //到endR+1 是因为最后一行也要打印
        while(tR != endR + 1){
            //打印两点之间的元素
            printLevel(matrix, tR, tC, dR, dC,fromUp);
            /**
             *上坐标tc先沿着第一行移动 到最右面的元素则沿着最后一列移动
             * ------------>
             * |            |
             * |            |
             * |            |
             * ------------>
             * 下坐标先沿着左面向下移动 再往右移动
             */
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    /**
     * 根据f判断打印从上还是从下
     */
    private void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if(f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        }
        else{
                while(dR != tR - 1){
                    System.out.print(m[dR--][dC++] + " ");
            }
        }
    }
}
