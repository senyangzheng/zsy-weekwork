package week04.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @projectName: zsy-weekwork
 * @package: week04
 * @description: 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 * @author: zsy
 * @create: 2022/5/29 17:02
 **/
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(1);
        new Sum(barrier).start();
    }

    static class Sum extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Sum(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(3000);      //以睡眠来模拟写入数据操作
                System.out.println("异步计算结果为：" + sum(36));
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        }
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