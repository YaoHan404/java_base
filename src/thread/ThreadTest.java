package thread;


//1. 继承Thread
class MyThread extends Thread{
    // 2. 重写run(), 子线程需要执行的操作全部放在run()中
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i == 10)
                this.yield(); // 因为继承了Thread，所以Mythread也有yield()
                // Thread.currentThread().yield(); // 这里和this.yield()一样
            System.out.println("子线程进行中"+i);
        }
    }
}

public class ThreadTest {
    public static void  main(String[] args){
        Thread.currentThread().setName("主线程");
        // 3. 创建thread类的子类的对象
        MyThread t1 = new MyThread();
        t1.setName("子线程");
        // 4. 通过对象调用start()
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("主线程进行中"+i);
        }
    }
}
