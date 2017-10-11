import java.util.ArrayList;

import static sun.swing.MenuItemLayoutHelper.max;

//动态规划经典练习
public class DynamicProgramming {
    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();

        //No1.塔树测试用例
        int[][] array = new int[][]{
                {5},
                {8,4},
                {3,6,9},
                {7,2,9,5}
        };
        System.out.println(dp.towerTree(array));

        //No2.∑乘法表测试用例
        String str = "bbbba";
        System.out.println(dp.multiplication(str));

        //No3.跳台阶测试用例
        int target = 5;
        System.out.println(dp.jumpFloor(target));

        //No4.LIS测试用例
        int[] array2 = new int[]{5,6,7,1,2,8,7,2};
        System.out.println(dp.findLIS(array2));
    }

    /**
     * No1.塔树选择和最大问题
     *
     * 一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
     * 每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
     *      5
     *     8 4
     *    3 6 9
     *   7 2 9 5
     * 例子中的最优方案是：5 + 8 + 6 + 9 = 28。
     */
    public int towerTree(int[][] array){
        /**
         * 分析：
         * dp(x,y)：表示第x层第y个数所经过的最大值。
         * dp(x,y)={
         *      array[x][y]  当x=0;
         *      dp[x-1,y] + array[x][y] 当x!=0,y=0;
         *      dp[x-1,y-1] + array[x][y] 当x!=0,y=x;
         *      max(dp[x-1,y-1],dp[x-1,y]) + array[x][y] 当x!=0;
         * }
         */
        int x = array.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        //计算最底层每一个数字的最大值
        for(int i=0;i<=x;i++){
            list.add(towerTreeDP(array,x,i));
        }
        list.sort(null);
        return list.get(list.size()-1);
    }
    private int towerTreeDP(int[][] array,int x,int y){
        if(x==0)return array[0][0];

        if(y==0){
            return towerTreeDP(array,x-1,y) + array[x][y];
        }else if(y==x){
            return towerTreeDP(array,x-1,y-1) + array[x][y];
        }else {
            return max(towerTreeDP(array,x-1,y),towerTreeDP(array,x-1,y-1))
                    + array[x][y];
        }
    }

    /**
     * No2.∑乘法表问题
     *
     * ∑ | a	b	c
     * ——————————————
     * a | b	b	a
     * b | c	b	a
     * c | a	c	c
     *
     * 依此乘法表,对任一定义于∑上的字符串,适当加括号表达式后得到一个表达式。
     * 例如,对于字符串x=bbbba,它的其中一个加括号表达式为i(b(bb))(ba)。
     * 依乘法表,该表达式的值为a。试设计一个动态规划算法,对任一定义于∑上的字符串x=x1x2…xn，
     * 计算有多少种不同的加括号方式,使由x导出的加括号表达式的值为a
     * 要求：
     * 输入：输入一个以a,b,c组成的任意一个字符串。
     * 输出：计算出的加括号方式数。
     */
    public int multiplication(String str){
        /**
         * 分析：
         * 所有的方式数 = 结果为a的方式数 + 结果为b的方式数 + 结果为c的方式数。
         * 我们用0表示a，1表示b，2表示c。
         * dp[i][j][0]：表示字符串从i到j，结果为a的方式数。
         * 结果为a的方式有：a*c + b*c + c*a
         * dp[i][j][0]={
         *     dp[i][m][0] * dp[m+1][j][2]
         *   + dp[i][m][1] * dp[m+1][j][2]
         *   + dp[i][m][2] * dp[m+1][j][0]
         * }
         * 其中i<=m<j。
         */
        //java默认为int数组赋值为0
        int dp[][][] = new int[str.length()][str.length()][3];
        char[] chars = str.toCharArray();
        int n=0;
        //为三维数组赋值，0:a,1:b,2:c
        for(char c:chars){
            dp[n][n][c - 'a'] = 1;
            n++;
        }
        for(int k=1;k<n;k++){ //将字符串分为以k长度的括号
            for(int i=0;i<n-k;i++){
                int j=i+k;
                for(int m=i;m<j;m++){
                    dp[i][j][0] += dp[i][m][2]*dp[m+1][j][0] //a=c*a
                            + dp[i][m][0]*dp[m+1][j][2]      //a=a*c
                            + dp[i][m][1]*dp[m+1][j][2];     //a=b*c
                    dp[i][j][1] += dp[i][m][0]*dp[m+1][j][0] //b=a*a
                            + dp[i][m][0]*dp[m+1][j][1]      //b=a*b
                            + dp[i][m][1]*dp[m+1][j][1];     //b=b*b
                    dp[i][j][2] += dp[i][m][1]*dp[m+1][j][0] //c=b*a
                            + dp[i][m][2]*dp[m+1][j][1]      //c=c*b
                            + dp[i][m][2]*dp[m+1][j][2];     //c=c*c
                }
            }
        }
        return dp[0][n-1][0];
    }

    /**
     * No.3跳台阶
     *
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public int jumpFloor(int n){
        /**
         * 分析：
         * dp(n)：表示跳第n阶台阶一共的跳法。
         * dp(n)={
         *     0    当n<=0;
         *     1    当n=1;
         *     2    当n=2;
         *     dp(n-1) + dp(n-2)  当n>2;
         * }
         */
        if(n<=0) return 0;
        if(n<=2) return n;
        return jumpFloor(n-1) + jumpFloor(n-2);
    }

    /**
     * No.4最长递增子序列(LIS)
     *
     * 给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）。
     * 例如：给定一个长度为6的数组A{5， 6， 7， 1， 2， 8}，
     * 则其最长的单调递增子序列为{5，6，7，8}，长度为4。
     * 输入：一个数组。
     * 输出：最长递增子序列的长度。
     */
    //有bug，明天再调
    public int findLIS(int[] array){
        if(array.length==0)return 0;
        findLISDP(array,array.length-1);
        return max;
    }
    int max = 0;
    public int findLISDP(int[] array,int n){
        if(n==0) return 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(array[i] < array[n]){
                list.add(findLISDP(array,i));
            }else {
                list.add(1);
            }

        }
        list.sort(null);
        int temp = list.get(list.size()-1);
        if(max<temp) max=temp;
        return temp;
    }
}