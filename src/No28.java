import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//字符串的排列
public class No28 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length()==0){
            return res;
        }

        HashSet<String> set = new HashSet<>();
        doPermute(set,str.toCharArray(),0);
        res.addAll(set);
        Collections.sort(res);

        return res;
    }

    public void doPermute(HashSet<String> set,char[] str,int begin){
        if(begin == str.length){
            set.add(new String(str));
            return;
        }
        for(int i=begin;i<str.length;i++){
            swap(str,begin,i);
            doPermute(set,str,begin+1);
            swap(str,begin,i);
        }
    }

    public void swap(char[] str,int i,int j){
        if(i!=j){
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }
}
