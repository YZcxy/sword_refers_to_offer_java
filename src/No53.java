//正则表达式匹配
public class No53 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchHandler(str,0,pattern,0);
    }

    private  boolean matchHandler (char[] str1,int index1,char[] str2,int index2) {
        if (index1 == str1.length && index2 == str2.length) {
            return true;
        }
        if (index1 != str1.length && index2 == str2.length) {
            return false;
        }
        if (index2+1<str2.length && str2[index2+1] == '*') {
            if ((index1 != str1.length && str1[index1] == str2[index2])
                    || (str2[index2] == '.' && index1 != str1.length)) {
                return matchHandler(str1,index1,str2,index2 + 2)
                        || matchHandler(str1,index1 + 1,str2,index2 + 2)
                        || matchHandler(str1,index1 + 1,str2,index2);
            } else {
                return matchHandler(str1,index1,str2,index2 + 2);
            }
        }
        if ((index1 != str1.length && str1[index1] == str2[index2])
                || (str2[index2] == '.' && index1 != str1.length)) {
            return matchHandler(str1,index1+1,str2,index2+1);
        }
        return false;
    }
}
