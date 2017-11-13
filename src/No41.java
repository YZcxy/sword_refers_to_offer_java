import java.util.ArrayList;
import java.util.HashMap;

//和为S的连续正数序列
public class No41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>(2);
        if (array.length <= 0) return result;
        int[][] temp = new int[array.length/2][3];
        int index = 0;
        int min = Integer.MAX_VALUE;

        int begin = 0;
        int end = array.length-1;

        while (begin < end) {
            if ((array[begin] + array[end]) > sum) {
                end--;
            } else if ((array[begin] + array[end]) < sum) {
                begin++;
            } else {
                temp[index][0] = array[begin];
                temp[index][1] = array[end];
                temp[index][2] = array[begin] * array[end];
                if (temp[index][2] < min) {
                    min = temp[index][2];
                }
                begin++;
                end--;
                index++;
            }
        }
        for (int i=0;i<temp.length;i++) {
            if (temp[i][3] == min) {
                result.add(temp[i][0]);
                result.add(temp[i][1]);
                break;
            }
        }
        return result;
    }
}
