package others;
//剑指offer 2题  实现一个单例
//静态类内部加载
/*
使用内部类的好处是，静态内部类不会在单例加载时就加载，而是在调用getInstance()方法时才进行加载，达到了类似懒汉模式的效果，而这种方法又是线程安全的。
 */
public class singleTon_2 {
    private static class SingletonHolder{
        private static singleTon_2 instance=new singleTon_2();
    }
    private singleTon_2(){
        System.out.println("Singleton has loaded");
    }
    public static singleTon_2 getInstance(){
        return SingletonHolder.instance;
    }

}
//懒汉模式
 class SingletonDemo {
     private static SingletonDemo instance;

     private SingletonDemo() {

     }

     public static SingletonDemo getInstance() {
         if (instance == null) {
             instance = new SingletonDemo();
         }
         return instance;
     }
 }
 //线程安全的懒汉模式
 class SingletonDemo1 {
     private static SingletonDemo1 instance;
     private SingletonDemo1(){

     }
     public static synchronized SingletonDemo1 getInstance(){
         if(instance==null){
             instance=new SingletonDemo1();
         }
         return instance;
     }
 }
 //饿汉模式
 class SingletonDemo2 {
     private static SingletonDemo2 instance=new SingletonDemo2();
     private SingletonDemo2(){

     }
     public static SingletonDemo2 getInstance(){
         return instance;
     }
 }
 //枚举方法  最好的方法
 enum SingletonDemo3{
     INSTANCE;
     public void otherMethods(){
         System.out.println("Something");
     }
 }
 //枚举中构造方法私有，每个实例都是static final 只能被实例化一次。
 /*
(1)自由序列化。

(2)保证只有一个实例。

(3)线程安全。
  */

//public class Hello {
//    public static void main(String[] args){
//        SingletonDemo.INSTANCE.otherMethods();
//    }
//}

//双重校验锁法

 class SingletonDemo4 {
    private volatile static SingletonDemo4 instance;
    private SingletonDemo4(){
        System.out.println("Singleton has loaded");
    }
    public static SingletonDemo4 getInstance(){
        if(instance==null){
            synchronized (SingletonDemo4.class){
                if(instance==null){
                    instance=new SingletonDemo4();
                }
            }
        }
        return instance;
    }
}
/*
STEP 1. 线程A访问getInstance()方法，因为单例还没有实例化，所以进入了锁定块。

STEP 2. 线程B访问getInstance()方法，因为单例还没有实例化，得以访问接下来代码块，而接下来代码块已经被线程1锁定。

STEP 3. 线程A进入下一判断，因为单例还没有实例化，所以进行单例实例化，成功实例化后退出代码块，解除锁定。

STEP 4. 线程B进入接下来代码块，锁定线程，进入下一判断，因为已经实例化，退出代码块，解除锁定。

STEP 5. 线程A获取到了单例实例并返回，线程B没有获取到单例并返回Null。

理论上双重校验锁法是线程安全的，并且，这种方法实现了lazyloading。
 */