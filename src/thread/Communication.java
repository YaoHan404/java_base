package thread;

/**
 * 线程通信的例子，使用两个线程交替打印1-100
 *
 * wait() 当前线程进入阻塞，并释放同步监视器
 * notify() 唤醒一个被wait()的方法, 若有多个被wait()的就唤醒优先级最高的
 * notifyAll() 唤醒所有被wait()的方法
 *
 * 使用说明：
 *  上述三个方法须要用在synchronized的方法或者代码块中
 *  上述三个方法的调用者，必须是synchronized的同步监视器，否则IllegalMonitorStateException
 *    例如，synchronized(this), 就得是this.wait()（写代码的时候可以省略this）
 *  这三个方法不是定义在Thread类，而是Object类（因为任何一个对象都可以用作同步监视器，所以任意一个对象都可以调用这三个方法）
 *
 * @author han yao
 * @date 2020/11/11 下午10:05
 */
class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){
            // 保证线程安全
            synchronized (this) {

                // 唤醒另一个线程
                notify(); // 只唤醒被同一个锁锁住的其中一个线程
                // notifyAll(); // 唤醒被同一个锁锁住的所有线程

                if (number < 100) {
                    // 打印慢一点
                    try{
                        Thread.sleep(10);
                    }catch (Exception e){}
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    // 进程通讯, 使得调用wait()方法的线程进入阻塞, 但是没有人唤醒
                    try {
                        wait();
                    }catch (Exception e){}

                } else {
                    break;
                }
            }
        }
    }
}

public class Communication {
    static public void main(String[] args){
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        t1.start();
        t2.start();
    }
}


