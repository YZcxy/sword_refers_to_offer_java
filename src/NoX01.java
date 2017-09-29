//这是一个根据实际项目需求，设计的一个算法

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.List;

//有两个有序递增数组array1和array2
//判断array2中相对array1多了的数据和少了的数据
public class NoX01 {
    public static void fingChanges(ArrayList<Integer> array1,ArrayList<Integer> array2){
        //定义两个指针，index1指向array1，index2指向array2
        int index1 = 0;
        int index2 = 0;

        //两个指针分别指向两个数组。
        //当两个指针的值相等时，说明没有增加也没有丢失，两个指针继续向下。
        //当array1的值大于array2的值，说明array2增加了一个数据，index1不变，将index2继续向下。
        //当array1的值小于array2的值，说明array2丢失了一个数据，index1继续向下，将index2不变。
        while(index1<array1.size() && index2<array2.size()){
            //这里敲黑板了，因为ArrayList<Integer>.get(index)返回的是一个Integer
            //如果-128<Integer<127,那么返回int;否则返回的是一个新的Integer对象
            //所以判断不能用 == ,只能用equals。
            if(array1.get(index1).equals(array2.get(index2))){
                index1++;
                index2++;
                continue;
            }
            if(array1.get(index1) > array2.get(index2)){
                System.out.println("增加了: " + array2.get(index2));
                index2++;
                continue;
            }
            if(array1.get(index1) < array2.get(index2)){
                System.out.println("丢失了: " + array1.get(index1));
                index1++;
                continue;
            }
        }

        if(index1 == array1.size() && index2 == array2.size()){
            return;
        }else{
            if(index1 != array1.size()){
                for (;index1<array1.size();index1++) {
                    System.out.println("丢失了: " + array1.get(index1));
                }
            }else if(index2 != array2.size()){
                for (;index2<array2.size();index2++) {
                    System.out.println("增加了: " + array2.get(index2));
                }
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();

        array1.add(1);
        array1.add(4);
        array1.add(5);
        array1.add(6);
        array1.add(9);
        array1.add(12);
        array1.add(123);
        array1.add(125);
        array1.add(1001);
        array1.add(12312);


        array2.add(5);
        array2.add(6);
        array2.add(9);
        array2.add(12);
        array2.add(22);
        array2.add(33);
        array2.add(123);
        array2.add(125);
        array2.add(1001);
        array2.add(12312);
        array2.add(1231123);

        fingChanges(array1,array2);
    }
}
