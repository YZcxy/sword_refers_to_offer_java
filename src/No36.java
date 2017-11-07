//数组中的逆序对
public class No36 {
    //n平方不能满足需求，需要考虑并归排序
    public int InversePairs(int[] array) {
        if(array.length==0 || array==null)return 0;

        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i] = array[i];
        }

        return InverseHandler(array,copy,0,array.length-1);
    }

    public int InverseHandler(int[] data,int[] copy,int start,int end){
        if(start == end){
            copy[start] = data[start];
            return 0;
        }

        int length = (end-start)/2;

        int left = InverseHandler(data,copy,start,start+length);
        int right = InverseHandler(data,copy,start+length+1,end);

        //左边最后一个数
        int i = start+length;
        //右边最后一个数
        int j = end;
        //copy数组当前坐标
        int indexCopy = end;
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                //当data[i]大于data[j]的时候，说明data[i]大于j以前的所有数据。
                count += j - start - length;
            }else {
                copy[indexCopy--] = data[j--];
            }
        }

        //将while循环没有排序复制好的排序
        for (;i >= start;i--) {
            copy[indexCopy--] = data[i];
        }
        for (;j >= start + length + 1;j--) {
            copy[indexCopy--] = data[j];
        }

        //将排序好的copy给原数组
        for(int n = start; n <= end; n++) {
            data[n] = copy[n];
        }

        return left + right + count;
    }
}
