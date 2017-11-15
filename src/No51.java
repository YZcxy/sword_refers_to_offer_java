//数组中重复的数字
public class No51 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0;i < length - 1;i++) {
            for (int j = i + 1;j<length;j++) {
                if (numbers[i] == numbers[j]) {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }
}
