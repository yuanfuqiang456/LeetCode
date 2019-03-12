package others;
import java.lang.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Shunxuzhixing {
//    public static void main(String[] args) throws InterruptedException { //结果不大对
//        final Thread t1 = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                try {
//                    //Thread.sleep(5000);
//                    System.out.println(Thread.currentThread().getName());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        },"Thread-T1");
//        final Thread t2 = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                try {
//                    t1.join();
//                    //Thread.sleep(3000);
//                    System.out.println(Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"Thread-T2");
//        final Thread t3 = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                try {
//                    t2.join();
//                    //Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"Thread-T3");
//        t3.start();
//        t2.start();
//        t1.start();
//    }
public static void main(String[] args) throws InterruptedException {
    final Thread t1 = new Thread(new Runnable() {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run 1");
        }
    }, "T1");
    final Thread t2 = new Thread(new Runnable() {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run 2");
//            try {
//                //t1.join(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }, "T2");
    final Thread t3 = new Thread(new Runnable() {
        public void run() {
            System.out.println(Thread.currentThread().getName() + " run 3");
//            try {
//                t2.join(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }, "T3");
    // method1
    //t1.start();
    //t2.start();
    //t3.start();

//        method 2 使用 单个任务的线程池来实现。保证线程的依次执行
    ExecutorService executor = Executors.newSingleThreadExecutor();
    executor.submit(t1);
    executor.submit(t2);
    executor.submit(t3);
    executor.shutdown();
}
}
