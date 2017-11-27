import java.util.ArrayList;

//矩阵中的路径
public class No66 {
    int colss = 0;
    int rowss = 0;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || (rows == 0 && cols == 0) || str.length == 0) return false;
        boolean result = false;
        colss = cols;
        rowss = rows;
        for (int i = 0;i < matrix.length && !result;i++) {
            if (matrix[i] == str[0]) {
                int row = (i / colss) + 1;
                int col = (i % colss) + 1;
                ArrayList<Integer> ways = new ArrayList<>();
                ways.add(i);
                result = isPass(matrix,row,col,str,0,ways);
            }
        }
        return result;
    }

    private boolean isPass(char[] matrix, int row, int col,char[] str,int curr,ArrayList<Integer> ways) {
        if (curr == str.length-1) return true;
        boolean result = false;

        //向上走
        if (row > 1) {
            int upIndex = (row-2)*colss+col-1;
            if (!ways.contains(upIndex) && matrix[upIndex] == str[curr+1]) {
                ways.add(upIndex);
                result = isPass(matrix,row-1,col,str,curr+1,ways);
                ways.remove(ways.size()-1);
            }
        }
        //向下走
        if (row < rowss && !result) {
            int downIndex = (row)*colss+col-1;
            if (!ways.contains(downIndex) && matrix[downIndex] == str[curr+1]) {
                ways.add(downIndex);
                result = isPass(matrix,row+1,col,str,curr+1,ways);
                ways.remove(ways.size()-1);
            }
        }
        //向左走
        if (col > 1 && !result) {
            int leftIndex = (row-1)*colss+col-2;
            if (!ways.contains(leftIndex) && matrix[leftIndex] == str[curr+1]) {
                ways.add(leftIndex);
                result = isPass(matrix,row,col-1,str,curr+1,ways);
                ways.remove(ways.size()-1);
            }
        }
        //向右走
        if (col < colss && !result) {
            int rightIndex = (row-1)*colss+col;
            if (!ways.contains(rightIndex) && matrix[rightIndex] == str[curr+1]) {
                ways.add(rightIndex);
                result = isPass(matrix,row,col+1,str,curr+1,ways);
                ways.remove(ways.size()-1);
            }
        }
        return result;
    }
}
