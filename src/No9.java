/**
* 【斐波那契数列】
* 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
*/
public class No9 {
    public int Fibonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
    //效率更高
    public int Fibonacci_2(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int f1=0;
        int f2=1;
        int res=0;
        for(int i=2;i<=n;i++){
            res = f1+f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
