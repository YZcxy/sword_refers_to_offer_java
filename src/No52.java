//构建乘积数组
public class No52 {
    public int[] multiply(int[] A) {
        int [] B = new int[A.length];
        for (int i = 0;i < A.length;i++) {
            int temp = 1;
            for (int j = 0;j < A.length;j++) {
                if (i == j) {
                    temp *= 1;
                } else {
                    temp *= A[j];
                }
            }
            B[i] = temp;
        }
        return B;
    }
}
