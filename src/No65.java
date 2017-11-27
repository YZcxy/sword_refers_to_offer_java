import java.util.ArrayList;

//滑动窗口的最大值
public class No65 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length) return result;
        for (int i = 0;i <= num.length-size;i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0;j < size;j++) {
                if (num[i+j] > max) {
                    max = num[i+j];
                }
            }
            result.add(max);
        }
        return result;
    }
}
