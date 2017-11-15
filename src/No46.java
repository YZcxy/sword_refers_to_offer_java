//求1+2+..+n
public class No46 {
    public int Sum_Solution(int n) {
        int ans = n;
        //短路逻辑，极其精妙，如果ans<=0，后面就不会执行，以次来作为递归终点。
        boolean temp = ans>0 && (ans += Sum_Solution(n - 1))>0;
        return ans;
    }
}
