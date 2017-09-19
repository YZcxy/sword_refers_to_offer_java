//二维数组中的查找
public class No3 {
    public boolean Find(int target, int [][] array) {
        int a = array.length;
        int b = array[0].length;
        int i = a-1;
        int j = 0;

        while(i>=0&&j<b){
            if(target == array[i][j])
                return true;
            if(target > array[i][j]){
                j++;
                continue;
            }
            if(target < array[i][j]){
                i--;
                continue;
            }
        }
        return false;
    }
}
