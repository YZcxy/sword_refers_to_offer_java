//翻转单词顺序
public class No42_1 {
    public String ReverseSentence(String str) {
        if (str.length() == 0 || str == null) return str;
        String[] array = str.split(" ");
        if(array.length == 0) return str;
        StringBuffer sb = new StringBuffer();
        for (int i=array.length-1;i>=0;i--) {
            sb.append(array[i]);
            if(i != 0) {
                sb.append(' ');
            }
        }
        return  sb.toString();
    }
}
