import java.util.HashMap;
import java.util.Map;

//数组中出现次数超过一半的数字
public class No29 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0)return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i: array) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue()>(array.length/2)){
                return entry.getKey();
            }
        }
        return 0;
    }
}
