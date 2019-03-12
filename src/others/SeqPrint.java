package others;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Print implements Runnable {

    Object nxt, cur;
    public Print(Object cur, Object nxt) {
        this.cur = cur;
        this.nxt = nxt;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            synchronized (cur) {
                synchronized (nxt) {
                    System.out.println(Thread.currentThread().getName());
                    nxt.notify();
                }
                try {
                    cur.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class AlternateDemo {
    //标志当前由哪一个线程输出，1代表A，2代表B，3代表C
    private int number = 1;

    Lock lock = new ReentrantLock();

    //Condition的强大之处在于它可以为多个线程间建立不同的Condition
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    // loopNum:当前循环轮数
    public void loopA(int loopNum) {
        //上锁
        lock.lock();
        try {
            while (number != 1) {
                //等待
                condition1.await();
            }

            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
            number = 2;
            //唤醒
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //确保释放锁
            lock.unlock();
        }
    }

    public void loopB(int loopNum) {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }

            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
            number = 3;
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void loopC(int loopNum) {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }

            System.out.println(Thread.currentThread().getName() + ", currentLoopNum is " + loopNum);
            number = 1;
            condition1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class SeqPrint {

    public static void main(String[] args)throws InterruptedException {
//        AlternateDemo ad = new AlternateDemo();//循环打印ABC
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++)
//                    ad.loopA(i);
//            }
//        }, "A").start();
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++)
//                    ad.loopB(i);
//            }
//        }, "B").start();
//
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++)
//                    ad.loopC(i);
//            }
//        }, "C").start();
        Object A = new Object();
        Object B = new Object();
        Object C = new Object();
        Thread At = new Thread(new Print(A, B), "A");
        Thread Bt = new Thread(new Print(B, C), "B");
        Thread Ct = new Thread(new Print(C, A), "C");
        At.sleep(100);
        At.start();
        Bt.sleep(100);
        Bt.start();
        Ct.sleep(100);
        Ct.start();

//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int K = in.nextInt();
//
//        long sum = 0;
//
//        long KMulti = 1;
//        for (int i = 1; i <= K; i++) {
//            KMulti = (i * KMulti);
//        }
//
//        for (int i = 1; i <= K; i++) {
//            long iMulti = 1;
//            for (int j = 1; j <= i; j++) {
//                iMulti = (j * iMulti);
//            }
//
//            long kiMulti = 1;
//            for (int j = 1; j <= K - i; j++) {
//                kiMulti = (j * kiMulti);
//            }
//
//            long res = KMulti / (iMulti * kiMulti);
//
//            sum += (Math.pow(-1, K - i) * Math.pow(i, N) * res);
//        }
//
//        System.out.println("" + sum % 772235);
//    }
    }

}

