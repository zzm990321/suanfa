package matrixAndArray;

/**
 * 给定一个N×N的矩阵matrix，在这个矩阵中，只有0和1两种值，
 * 返回边框全是1的最大正方形的边长长度。
 * 容易的解法
 * 1 共有N*N个位置
 * 2 对每一个位置都看是否成为边长N-1的正方形左上角
 * 3 检查的过程 遍历边框是否全是1
 *
 * 可进行简化 对步骤三进行预处理
 * 1 根据矩阵得到两个矩阵right和down right[i][j] 表示（i,j)向右有多少个连续的 1
 *                                down[i][j] 表示向下有多少个连续的 1
 * 2 从右下角向上计算 即矩阵的最后一列 所以，如果matrix[i][n-1]==1，则令right[i][n-1]=1，否则为0。
 * 对down矩阵来说，如果matrix[i][n-1]==1，因为down[i+1][n-1]表示包括位置（i+1，n-1）在内并往下有多少个连续的 1。
 * 所以，如果位置（i，n-1）是 1，那么，令 down[i][n-1]=down[i+1][n-1]+1；
 * 如果matrix[i][n-1]==0，则令down[i][n-1]=0
 * 3 从右下角开始往左计算，即在matrix最后一行上计算，位置可以表示为（n-1，j）。
 * 对right矩阵来说，如果 matrix[n-1][j]==1，因为 right[n-1][j+1]表示包括位置（n-1，j+1）在内右边有多少个连续的 1。
 * 所以，如果位置（n-1，j）是 1，则令right[n-1][j]==right[n-1][j+1]+1；
 * 如果matrix[n-1][j]==0，则令right[n-1][j]==0。
 * 对down矩阵来说，最后一列的下边没有内容。所以，如果matrix[n-1][j]==1，令down[n-1][j]=1，否则为0。
 * 4 如果matrix[i][j]==1，则令right[i][j]=right[i][j+1]+1，down[i][j]=down[i+1][j]+1。
 *  如果matrix[i][j]==0，则令right[i][j]==0，down[i][j]==0。
 *
 *
 * 得到这个矩阵后如何加速呢
 * 1）位置（i，j）的右边和下边连续为1的数量必须都大于或等于a（right[i][j]＞=a&&down[i][j]＞=a），否则说明上边界和左边界的1不够。
 * 2）位置（i，j）向右跳到位置（i，j+a-1），这个位置是正方形的右上角，那么这个位置的下边连续为1的数量也必须大于或等于a（down[i][j+a-1]＞=a），否则说明右边界的1不够。
 * 3）位置（i，j）向下跳到位置（i+a-1，j），这个位置是正方形的左下角，那么这个位置的右边连续为1的数量也必须大于或等于a（right[i+a-1][j]＞=a），否则说明下边界的1不够。
 * */
public class Code_20_getMaxSize {
    public void setBorderMap(int[][] m,int[][] right,int[][] down){
        int r = m.length;
        int c = m[0].length;
        if(m[r-1][c-1] == 1){
            right[r-1][c-1] = 1;
            down[r-1][c-1] = 1;
        }
        for(int i = r - 2; i!= -1;i--){
            if(m[i][c-1] == 1){
                right[r-1][c-1] = 1;
                down[i][c-1] = down[i+1][c-1] + 1;
            }
        }
        for (int i = c - 2; i != -1 ; i--) {
            if(m[r-1][i] == 1){
                right[r-1][i] = right[r-1][i+1] + 1;
                down[r-1][i] = 1;
            }
        }
        for(int i = r-2;i != -1;i--){
            for(int j = c-2;j!=-1;j--){
                if(m[i][j]==1){
                    right[i][j] = right[i][j+1]+1;
                    down[i][j] = down[i+1][j] + 1;
                }
            }
        }
    }

    public int getMaxSize(int[][] m){
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m,right,down);
        for(int size = Math.min(m.length,m[0].length);size != 0;size--){
            if(hasSizeOfBorder(size,right,down)){
                return size;
            }
        }
        return 0;
    }

    public boolean hasSizeOfBorder(int size,int[][] right , int[][] down){
        for(int i =0;i != right.length-size+1;i++){
            for(int j = 0;j != right[0].length -size + 1;j++){
                if(right[i][j]>=size && down[i][j] >= size
                        && right[i+size-1][j]>=size
                        && down[i][j+size-1]>=size
                ){
                    return true;
                }
            }
        }
        return false;
    }
}
