package week01jvm;

public class Hello {

    private static final String INIT_STR = "YYYz";

    static {
        System.out.println("init!!!!!!!!!");
        System.out.println(INIT_STR);
    }

    public void hello() {
        System.out.println("Hello, classLoader!");
    }

}