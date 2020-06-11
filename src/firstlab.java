
public class firstlab {
    public static void main(String[] args) {
        final int a = 1, b = 1;
        final int n = 5, m = 5;
        char c = 0;
        if (a <= c && n >= c) {
            System.out.println("Nelz9 delit na 0");
            return;
        }
        for(float i = 0;i < n; i++) {
            for (float j = 0; j < m; j++) {
                c += (i + j) / (i - 1);
            }
        }
        System.out.println((int)c);
    }
}
