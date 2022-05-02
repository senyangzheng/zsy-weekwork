package week01jvm;

import java.util.Base64;

/**
 * @program: zsy-weekwork
 * @description: 自定义ClassLoader
 * @author: 郑森洋
 * @create: 2022/05/02
 */
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        new HelloClassLoader().findClass("week01jvm.Hello").newInstance();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String base64 = "yv66vgAAADQAJAoACAAUCQAVABYIABcKABgAGQgAGgcAGwgAHAcAHQEACElOSVRfU1RSAQASTGphdmEvbGFuZy9TdHJpbmc7AQANQ29uc3RhbnRWYWx1ZQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAVoZWxsbwEACDxjbGluaXQ+AQAKU291cmNlRmlsZQEACkhlbGxvLmphdmEMAAwADQcAHgwAHwAgAQATSGVsbG8sIGNsYXNzTG9hZGVyIQcAIQwAIgAjAQANaW5pdCEhISEhISEhIQEAD3dlZWswMWp2bS9IZWxsbwEABFlZWXoBABBqYXZhL2xhbmcvT2JqZWN0AQAQamF2YS9sYW5nL1N5c3RlbQEAA291dAEAFUxqYXZhL2lvL1ByaW50U3RyZWFtOwEAE2phdmEvaW8vUHJpbnRTdHJlYW0BAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWACEABgAIAAAAAQAaAAkACgABAAsAAAACAAcAAwABAAwADQABAA4AAAAdAAEAAQAAAAUqtwABsQAAAAEADwAAAAYAAQAAAAMAAQAQAA0AAQAOAAAAJQACAAEAAAAJsgACEgO2AASxAAAAAQAPAAAACgACAAAADQAIAA4ACAARAA0AAQAOAAAAMQACAAAAAAARsgACEgW2AASyAAISB7YABLEAAAABAA8AAAAOAAMAAAAIAAgACQAQAAoAAQASAAAAAgAT";
        byte[] bytes = decode(base64);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
