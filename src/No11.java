//数值的整数次方
public class No11 {
    public double Power(double base, int n) {
        double res = 1, curr = base;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        } else {
            return 1;
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1)
                res *= base;
            base *= base;
            exponent >>= 1;
        }
        return n >= 0 ? res : (1 / res);
    }

}
