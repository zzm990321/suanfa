package matrixAndArray;

/**
 * 顺时针旋转矩阵90度 难度 一
 */
public class Code_01_rotateMatrix {
    public void rotate(int[][] matrix){
        //左上角
        int tR = 0;
        int tC = 0;
        //右下角
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR < dR){
            //从外层向里层循环每次一层
            rotateEdge(matrix,tR++, tC++, dR--, dC--);
        }
    }

    private void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        //每一层需要调整的组数
        int times = dC - tC;
        int tmp = 0;
        for(int i = 0; i != times; i++){
            //每次循环调整一组
            tmp = m[tR][tC+i];
            m[tR][tC+i] = m[dR-i][tC];
            m[dR-i][tC] = m[dR][dC-i];
            m[tR+i][dC] = tmp;
        }
    }
}
