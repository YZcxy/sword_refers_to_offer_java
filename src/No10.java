/**
* 【二进制中1的个数】
* 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
*/
public class No10 {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if((n&flag)!=0){
                count++;
            }
            flag=flag<< 1;
        }
        return count;
    }

    //最优解
    public int NumberOf1_2(int n){
        int count = 0;
        while(n!=0){
            ++count;
            n = (n-1)&n;
        }
        return count;
    }
}
