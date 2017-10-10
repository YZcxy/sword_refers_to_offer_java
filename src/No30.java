import java.util.ArrayList;
import java.util.Collections;

//最小的K个数
public class No30 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if(input.length==0 || k==0 ||input.length<k)return list;

        for(int i:input){
            if(!list.contains(i)){
                if(list.size() != k){
                    list.add(i);
                }else {
                    Collections.sort(list);
                    if(i<list.get(k-1)){
                        list.set(k-1,i);
                    }
                }
            }
        }
        return list;
    }
}
