package matrixAndArray;

/**
 * 给定一个N×M的整型矩阵matrix和一个整数K，matrix的每一行和每一列都是排好序的。实现一个函数，判断K是否在matrix中。
 */
public class Code_06_isContains {
    /**
     * 从左下角或右上角开始
     * 本题从右上角开始 如果比k大 col = col-1
     *                  小 row = row + 1
     * @param matrix
     * @param k
     * @return
     */
    public boolean isContains(int[][] matrix,int k){
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col > -1){
            if(matrix[row][col] == k){
                return true;
            }else if(matrix[row][col] > k){
                col --;
            }else{
                row ++;
            }
        }
        return false;
    }
}
