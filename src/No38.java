//数组在排序数组中的出现的次数
public class No38 {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length <= 0) return 0;

        int num = 0;
        for (int temp : array) {
            if (temp == k) {
                num++;
            }
        }
        return num;
    }
}
