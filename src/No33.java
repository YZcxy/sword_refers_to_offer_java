import java.math.BigInteger;
import java.util.HashSet;

//把数组排成最小的数
public class No33 {
    //第一中解法
    //将数组的所有排序排列出来，然后比较每种排序的大小
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length==0)return "";
        AllNumber(numbers,0);
        BigInteger minNumber= new BigInteger("9999999999999999");
        for (int[] array:set){
            StringBuffer cur=new StringBuffer();
            for(int i:array){
                cur.append(i);
            }
            BigInteger temp = new BigInteger(cur.toString());
            minNumber= temp.min(minNumber);
        }
        return minNumber.toString();
    }
    HashSet<int[]> set = new HashSet();
    public void AllNumber(int[] numbers,int begin){
        if(begin == numbers.length-1){
            //这里画个重点，需要加入的是数组的拷贝，而不是数组本身。
            set.add(numbers.clone());
        }else {
            for(int i=begin;i<numbers.length;i++){
                swap(numbers,begin,i);
                AllNumber(numbers,begin+1);
                swap(numbers,begin,i);
            }
        }
    }
    private void swap(int[] numbers,int i,int j){
        if(i!=j){
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }


    //另外一种解法
    //设定一种判断是否需要交互数组的两个元素的依据
    //然后根据依据对数组排序
    public String PrintMinNumber2(int [] numbers) {
        if(numbers.length==0)return "";
        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                doChange(numbers,i,j);
            }
        }
        StringBuffer res = new StringBuffer();
        for(int n:numbers){
            res.append(n);
        }
        return res.toString();
    }
    private void doChange(int[] numbers,int i,int j){
        if(numbers[i] == numbers[j])return;
        String tempIJ = Integer.toString(numbers[i]) + Integer.toString(numbers[j]);
        String tempJI = Integer.toString(numbers[j]) + Integer.toString(numbers[i]);
        BigInteger bigIJ = new BigInteger(tempIJ);
        BigInteger bigJI = new BigInteger(tempJI);

        if(bigJI.compareTo(bigIJ)<0){
            swap(numbers,i,j);
        }
    }
}
