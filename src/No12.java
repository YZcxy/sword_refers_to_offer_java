//打印1到最大的N位数
import java.math.BigInteger;
public class No12 {
    public static void PrintToMaxOfNDigits(int n){
        BigInteger number = BigInteger.valueOf(1);
        BigInteger index = BigInteger.valueOf(10);
        BigInteger j = BigInteger.valueOf(1);

        //找到最大的值
        int i = 0;
        while (++i < n){
            number = number.multiply(index);
        }

        //从1开始输出，直到最大值
        index = BigInteger.valueOf(1);
        while (!number.subtract(j).toString().equals("0")){
            System.out.println(j);
            j=j.add(index);
        }
    }
}

