//调整数组顺序使奇数位于偶数前面
public class No14 {
    public static void reOrderArray(int [] array) {
        if(array == null || array.length==0)
            return;
        int[] res = new int[array.length];
        int n=0;
        int m=array.length-1;
        for (int i=0;i<array.length;i++){
            if((array[i] & 0x1)==0)
                continue;
            res[n++] = array[i];
        }
        for (int j=array.length-1;j>=0;j--){
            if((array[j] & 0x1)!=0)
                continue;
            res[m--] = array[j];
        }
        for (int v=0;v<res.length;v++) {
            array[v] = res[v];
        }
    }
}
