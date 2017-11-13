import java.util.Arrays;

//扑克牌的顺子
public class No44 {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) return false;
        Arrays.sort(numbers);
        int index = 0;
        while (numbers[index] == 0) { index++;}
        if(index >= numbers.length-1) return true;
        if ((numbers[numbers.length-1] - numbers[index]) == numbers.length-1)
            return true;
        return false;
    }
}
