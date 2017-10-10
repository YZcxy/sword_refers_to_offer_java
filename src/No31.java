//连续子数组的最大和
public class No31 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        if(array.length == 0)return 0;
        for(int i:array){
            if(res+i<=i){
                res=i;
            }else {
                res += i;
            }
            if(res > max)max=res;
        }
        return max;
    }

    //动态规划版本
    //f(i)：以第i个数字结尾的子数组的最大值
    //f(i){
    //  pData[i]         i=0||f(i-1)<=0
    //  f(i-1)+pData[i]  i!=0&&f(i-1)>0
    // }
    public int FindGreatestSumOfSubArray2(int[] array) {
        if(array.length==0)return 0;

        FindGreatestSum(array,array.length-1);
        return nGreatSum;
    }
    int nGreatSum = Integer.MIN_VALUE;
    private int FindGreatestSum(int[] array,int nCur){
        if(nCur == 0)return array[0];

        int nCurSum = FindGreatestSum(array,nCur-1);

        if( nCurSum <= 0){
            if(nCurSum>nGreatSum)nGreatSum=nCurSum;
            return array[nCur];
        }else {
            if(nCurSum + array[nCur]>nGreatSum)nGreatSum=nCurSum;
            return nCurSum + array[nCur];
        }
    }
}
