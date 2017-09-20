//旋转数组的最小数字
public class No8 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)return 0;
        for(int i=0;i<array.length;i++){
            if(array[i] > array[i+1]){
                return array[i+1];
            }
        }
        return 0;
    }
}
