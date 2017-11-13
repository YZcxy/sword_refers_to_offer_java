//圆圈中最后剩下的数字
public class No45 {
    public int LastRemaining_Solution(int n, int m) {
        if (m == 0 || n == 0) return -1;
        int[] people = new int[n];
        for (int i = 0;i < n;i++){
            people[i] = i;
        }
        int num = 0;
        int peo = 0;
        int out = 0;
        while (out != n-1) {
            while (people[peo] == -1) {
                peo = addNum(peo,n);
            }
            if (num == m-1) {
                people[peo] = -1;
                out++;
            }
            num = addNum(num,m);
            peo = addNum(peo,n);
        }
        for (int i = 0;i < n;i++) {
            if(people[i] != -1) {
                return i;
            }
        }
        return -1;
    }

    private int addNum (int num,int m) {
        if (num == m-1) {
            return 0;
        }
        return ++num;
    }
}
