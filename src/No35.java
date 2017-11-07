import java.util.HashMap;

//第一个只出现一次的字符
public class No35 {
    public int FirstNotRepeatingChar(String str) {
        if(str.length()==0||str == null)return -1;
        HashMap<Character,Integer> map = new HashMap(str.length());

        char[] arrs = str.toCharArray();
        for (char temp:arrs) {
            if(map.get(temp)!=null){
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
            }

        }
        for(int i=0;i<arrs.length;i++){
            if(map.get(arrs[i])==1){
                return i;
            }
        }
        return 0;
    }

}
