//表示数值的字符串
public class No54 {
    public boolean isNumeric(char[] str) {
        if (str == null && str.length == 0) return false;
        int index = 0;
        if (str[index] == '+' || str[index] == '-') {
            index++;
        }
        boolean point = true;
        while (index < str.length) {
            if (isNumber(str[index])) {
                index++;
                continue;
            }
            if (str[index] == 'e' || str[index] == 'E') {
                if(index + 1 < str.length && (str[index+1] == '+' || str[index+1] == '-')) {
                    index ++;
                }
                if (index + 1 < str.length && isNumber(str[index+1])) {
                    index = index + 2;
                    point = false;
                    continue;
                } else {
                    return false;
                }
            }
            if (str[index] == '.') {
                if (point) {
                    index++;
                    point = false;
                    continue;
                } else {
                    return false;
                }
            }
            return false;
        }
        return true;
    }
    private boolean isNumber (char number){
        if((number - '0') <= 9 && (number - '0') >=0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        No54 n = new No54();
        String s = "123.45e+6";
        n.isNumeric(s.toCharArray());
    }
}
