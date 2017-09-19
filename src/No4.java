//替换空格
public class No4 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                res.append(str.charAt(i));
            } else {
                res.append("%20");
            }
        }
        return res.toString();
    }
}
