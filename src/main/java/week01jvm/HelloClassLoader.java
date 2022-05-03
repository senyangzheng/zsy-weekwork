package week01jvm;

import java.lang.reflect.Method;
import java.util.Base64;

/**
 * @program: zsy-weekwork
 * @description: 自定义ClassLoader
 * @author: 郑森洋
 * @create: 2022/05/02
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = new HelloClassLoader().findClass("Hello");
        Method helloMethod = clazz.getMethod("hello");
        helloMethod.invoke(clazz.newInstance());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        String base64 = "yv66vgAAADQAJAoACAAUCQAVABYIABcKABgAGQgAGgcAGwgAHAcAHQEACElOSVRfU1RSAQASTGphdmEvbGFuZy9TdHJpbmc7AQANQ29uc3RhbnRWYWx1ZQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAVoZWxsbwEACDxjbGluaXQ+AQAKU291cmNlRmlsZQEACkhlbGxvLmphdmEMAAwADQcAHgwAHwAgAQATSGVsbG8sIGNsYXNzTG9hZGVyIQcAIQwAIgAjAQANaW5pdCEhISEhISEhIQEAD3dlZWswMWp2bS9IZWxsbwEABFlZWXoBABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWACEABgAIAAAAAQAaAAkACgABAAsAAAACAAcAAwABAAwADQABAA4AAAAdAAEAAQAAAAUqtwABsQAAAAEADwAAAAYAAQAAAAMAAQAQAA0AAQAOAAAAJQACAAEAAAAJsgACEgO2AASxAAAAAQAPAAAACgACAAAADQAIAA4ACAARAA0AAQAOAAAAMQACAAAAAAARsgACEgW2AASyAAISB7YABLEAAAABAA8AAAAOAAMAAAAIAAgACQAQAAoAAQASAAAAAgAT";
        String base64 = "NQFFQf///8v/4/X/+f/x9v/w/+/3/+71/+3/7Pj/6/j/6v7/+cOWkZaLwf7//NfWqf7/+7yQm5r+//CzlpGasYqSnZqNq56dk5r+//qXmpOTkP7/9ayQio2cmrmWk5r+//W3mpOTkNGVnome8//4//f4/+nz/+j/5/7/7Leak5OQ09+ck56MjLOQnpuajd74/+bz/+X/5P7/+reak5OQ/v/vlZ6JntCTnpGY0LCdlZqci/7/75WeiZ7Qk56RmNCshoyLmpL+//yQiov+/+qzlZ6JntCWkNCvjZaRi6yLjZqeksT+/+yVnome0JaQ0K+NlpGLrIuNmp6S/v/4j42WkYuTkf7/6tezlZ6JntCTnpGY0KyLjZaRmMTWqf/e//r/+f///////f/+//j/9//+//b////i//7//v////rVSP/+Tv////7/9f////n//v////7//v/0//f//v/2////2v/9//7////2Tf/97fxJ//tO/////v/1////9f/9////+//3//r//v/z/////f/y";
        byte[] bytes = decode(base64);
        byte[] newBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            newBytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, newBytes, 0, bytes.length);
    }

    private byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
