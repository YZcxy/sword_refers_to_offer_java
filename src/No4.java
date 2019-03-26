/**
* 【替换空格】
* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/
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
