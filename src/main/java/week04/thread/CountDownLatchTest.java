package week04.thread;

import java.util.concurrent.*;

/**
 * @projectName: zsy-weekwork
 * @package: week04
 * @description: 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * @author: zsy
 * @create: 2022/5/29 17:02
 **/
public class CountDownLatchTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService exec = Executors.newCachedThreadPool();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        exec.execute(() -> {
            try {
                System.out.println("异步计算结果为：" + sum(36));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }

    private static int sum(int num) {
        return fibo(num);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

}
