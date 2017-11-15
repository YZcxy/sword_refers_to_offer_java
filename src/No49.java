//把字符串转换为整数
public class No49 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        int sum = 0;
        int index = 1;
        char[] chars = str.toCharArray();
        boolean flag = true;
        //判断第二位之后是否都为数字
        for (int i = str.length()-1;i > 0;i--) {
            if (! Character.isDigit(chars[i])) {
                flag = false;
            }
        }
        boolean fristnum = false;
        //判断第一位是数字还是符号
        if (flag) {
            if (Character.isDigit(chars[0])) {
                fristnum = true;
            } else if (chars[0] != '+' && chars[0] != '-') {
                flag = false;
            }
        }
        if (flag) {
            //将第二位之后组装成数
            for (int i = str.length()-1;i > 0;i--) {
                int temp = index * (chars[i] - '0');
                sum += temp;
                index *= 10;
            }
            //将第一位拼接上去
            if (fristnum) {
                int temp = index * (chars[0] - '0');
                sum += temp;
            } else if (chars[0] == '-') {
                sum = 0 - sum;
            }
        }
        return sum;
    }
}
