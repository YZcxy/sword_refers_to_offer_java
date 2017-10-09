import java.util.ArrayList;

//顺时针打印矩阵
//调试没问题，但是牛客网上过不了，不知道为什么
//上面的问题解决了，之前没有处理好长和宽为1的情况
public class No20 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int length = matrix.length;
        int width = matrix[0].length;
        int num = length < width?length:width;
        for(int i=0;i<(num+1)/2;i++){
            printOneMatrix(matrix,i,i,list);
        }
        return list;
    }

    public void printOneMatrix(int [][] matrix,int x,int y,ArrayList<Integer> list){
        int width = matrix[0].length-(x*2);
        int height = matrix.length-(y*2);
        if(height == 1){
            for(int i=0;i<width;i++){
                list.add(matrix[x][y++]);
            }
        }else if(width == 1){
            for(int i=0;i<height;i++){
                list.add(matrix[x++][y]);
            }
        }else {
            for(int i=1;i<width;i++){
                list.add(matrix[x][y++]);
            }
            for(int i=1;i<height;i++){
                list.add(matrix[x++][y]);
            }
            for(int i=1;i<width;i++){
                list.add(matrix[x][y--]);
            }
            for(int i=1;i<height;i++){
                list.add(matrix[x--][y]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1,2,3,4,5,6},
            {7,8,9,10,11,12},
            {13,14,15,16,17,18},
            {19,20,21,22,23,24},
            {25,26,27,28,29,30}
        };
        No20 n = new No20();
        ArrayList<Integer> list = n.printMatrix(matrix);
        for (int v:list) {
            System.out.print(v + " ");
        }
    }
}
