import java.util.*;

//丑数
public class No34 {
    //解法一：判断每一个数是否为丑数
    public int GetUglyNumber_Solution(int index) {
        int res = 0;
        if(index <= 0)return res;
        int cur = 1;
        while (index!=0){
            if(isUglyNumber(cur)){
                index--;
                res=cur;
            }
            cur++;
        }
        return res;
    }
    private boolean isUglyNumber(int number){
        while (number %2 == 0){
            number /= 2;
        }
        while (number %3 == 0){
            number /= 3;
        }
        while (number %5 == 0){
            number /=5;
        }
        return number==1;
    }

    public int GetUglyNumber_Solution2(int index) {
        if(index <= 0)return 0;
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        cur.add(1);
        while (res.size()<index){
            int temp = cur.remove(0);
            if(!set.contains(temp)){
                set.add(temp);
                res.add(temp);
            }
            cur.add(temp*2);
            cur.add(temp*3);
            cur.add(temp*5);
            Collections.sort(cur);
        }

        return res.get(index-1);
    }

    public static void main(String[] args) {
        No34 n = new No34();
        System.out.println(n.GetUglyNumber_Solution2(7));
    }
}
