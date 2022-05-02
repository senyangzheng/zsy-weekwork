package week01jvm;

/**
 * @program: zsy-weekwork
 * @description:
 * @author: 郑森洋
 * @create: 2022/04/23
 */
public class ClassDemo {
    public static void main(String[] args) {
        int a1 = 9, a2 = 1;
        char c1 = 'c', c2 = 'h';
        short s1 = 9, s2 = 1;
        long l1 = 9l, l2 = 9l;
        float f1 = 9.0f, f2 = 9.0f;
        double d1 = 9.0d, d2 = 9.0d;
        boolean b3 = true, b4 = true;
        byte b1 = 9, b2 = 1;

        int sumInt = a1 + a2;
        char sumChar = (char) (c1 + c2);
        short sumShort = (short) (s1 + s2);
        long sumLong = l1 + l2;
        float sumFloat = f1 + f2;
        double sumDouble = d1 + d2;
        byte sumByte = (byte) (b1 + b2);
    }
}
