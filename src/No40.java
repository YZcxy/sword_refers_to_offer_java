import java.util.HashMap;
import java.util.Map;

//数组中只出现一次的数
public class No40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length <= 0) return;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int temp : array) {
            if(map.get(temp) != null) {
                map.put(temp,map.get(temp)+1);
            } else {
                map.put(temp,1);
            }
        }

        int index = 1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue() == 1) {
                if (index == 1) {
                    num1[0] = entry.getKey();
                    index ++;
                } else {
                    num2[0] = entry.getKey();
                }
            }
        }
    }
}
