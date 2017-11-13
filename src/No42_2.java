//左旋转字符串
public class No42_2 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) return str;
        StringBuffer sb = new StringBuffer(str);
        while (n-- > 0) {
            char temp = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(temp);
        }
        return sb.toString();
    }
}
