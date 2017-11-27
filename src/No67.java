//机器人的运动范围
public class No67 {
    public int movingCount(int threshold, int rows, int cols)
    {
        int flag[][] = new int[rows][cols]; //记录是否已经走过
        return handler(0, 0, rows, cols, flag, threshold);
    }

    private int handler(int i,int j,int rows,int cols,int[][] flag,int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1) return 0;
        flag[i][j] = 1;
        return handler(i-1,j,rows,cols,flag,threshold)
                + handler(i+1,j,rows,cols,flag,threshold)
                + handler(i,j-1,rows,cols,flag,threshold)
                + handler(i,j+1,rows,cols,flag,threshold)
                + 1;
    }

    private int numSum(int i) {
        int sum = 0;
        do {
            sum += i%10;
        }while((i = i/10) > 0);
        return sum;
    }
}
