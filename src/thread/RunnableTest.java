package thread;

public class RunnableTest {
    public static void main(String[] args){
        // 3. 通过Thread类含参构造器创建线程对象。
        Ticket t = new Ticket();
        // 4. 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        t1.setName("t1窗口");
        t2.setName("t2窗口");
        t3.setName("t3窗口");
        // 5. 调用Thread类的start方法:开启线程,调用Runnable子类接口的run方法。
        t1.start();
        t2.start();
        t3.start();
    }
}

//1. 定义子类,实现Runnable接口。
class Ticket implements Runnable {
    private int tick = 100; //多个线程共享的数据
    Object obj = new Object(); // 多个线程公用一把锁, 如果是继承Thread的多线程，需要加static
    //2. 子类中重写Runnable接口中的run方法。
    public void run() {
        synchronized (obj) {
            while (true) {
                if (tick > 0) {
                    Thread.currentThread().yield();
//                try{
//                    Thread.sleep(10);
//                }catch(InterruptedException e){ e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName()
                            + "售出车票,tick号为:" +
                            tick--);
                } else
                    break;
            }
        }
    }
}