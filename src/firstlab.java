
public class firstlab {
    public static void main(String[] args) {
        final int a = 5, b = 5;
        char c = 0;
        for(float i = 0; i < a; i++) {
            for (float j = 0; j < b; j++) {
                c += (i + j) / (i - 1);
            }
        }
        System.out.println((int)c);
    }
}
