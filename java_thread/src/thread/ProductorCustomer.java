package thread;

/**
 * 生产者消费者问题，也是线程通信的一个应用
 *
 * 店员（Clerk）能存放的产品数量有上限，即未消费的产品数量有上限
 * 未消费的产品达到上限时，Productor需要停止生产
 * 产品消费完以后，Customer不能取走产品
 *
 * 分析：
 * 1. 是否多线程？
 *      是，Customer线程、Productor线程
 * 2. 是否存在共享数据？（即是否要考虑线程安全）
 *      存在，产品为共享数据
 * 3. 如何解决线程的安全问题？
 *      synchronized方法/代码块，或者Lock
 * 4. 是否涉及线程的通信？
 *      涉及，
 *
 * @author han yao
 * @date 2020/11/12 上午9:08
 */
public class ProductorCustomer {
    public static void main(String[] args){
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        Thread productorThread = new Thread(productor);
        Thread consumerThread1 = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer);
        productorThread.setName("productor1 ");
        consumerThread1.setName("consumer1 ");
        consumerThread2.setName("consumer2 ");
        productorThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}


class Clerk{
    private int productCount = 0;
    private final int MAX_PRODUCTION = 20;

    /*
    使用synchronized确保线程安全, 使得生产者和消费者只能有一个对产品（共享数据）进行操作
    因为不管是生产者线程，还是消费者线程，这里使用synchronized时，使用的同步监视器都是this，
    而生产者和消费者同一个Clerk实例，即这两个线程使用的是同一个this,所以同步监视器也是同一个
    */
    public synchronized void addProduct(){
        if(productCount < MAX_PRODUCTION){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ": 开始生产第" + productCount +"个产品");

            //线程通信，让其他阻塞状态的线程进入就绪
            notifyAll();
        }else{
            System.out.println(Thread.currentThread().getName() + "进入阻塞状态");
            try {
                wait();
            }catch (InterruptedException e){}
        }
    }

    public synchronized void getProduct(){
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + ": 开始消费第" + productCount +"个产品");
            productCount--;
            notifyAll();
        }else{
            System.out.println(Thread.currentThread().getName() + "进入阻塞状态");
            try {
                wait();
            }catch (InterruptedException e){}
        }
    }

}


class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // 每次线程被调度到，进入运行状态就会执行一次
        System.out.println(Thread.currentThread().getName() + "running");
        while (true){
            // 随机一段时间后生产产品
            try{
                int sleepTime = (int) (Math.random() * 1000);
                Thread.sleep(sleepTime);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}


class Consumer implements  Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // 每次线程被调度到，进入运行状态就会执行一次
        System.out.println(Thread.currentThread().getName() + "running");
        while (true){
            // 随机一段时间后取产品
            try{
                int sleepTime = (int) (Math.random() * 1000);
                Thread.sleep(sleepTime);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}