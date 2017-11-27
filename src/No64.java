import java.util.ArrayList;

//数据流中的中位数
public class No64 {
    ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        list.sort(null);
        if ((list.size() % 2) == 0) {
            return (list.get((list.size()/2)-1) + list.get(list.size()/2))/2.0;
        }else {
            return list.get(list.size()/2)/1.0;
        }
    }
}
