//整数1出现的次数
public class No32 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0)return 0;
        int res=0;
        for(int i=1;i<=n;i++){
            res += NumberOfNum(i);
        }
        return res;
    }
    public int NumberOfNum(int num){
        int res=0;
        while (num!=0){
            if(num%10 == 1){
                res++;
            }
            num /= 10;
        }
        return res;
    }
}
