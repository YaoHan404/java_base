package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *创建线程的方式四：线程池
 *
 * 提高响应速度(减少了创建新线程的时间)
 * 降低资源消耗(重复利用线程池中线程,不需要每次都创建)
 * 便于线程管理
 *   corePoolSize:核心池的大小
 *  maximumPoolSize:最大线程数
 *  keepAliveTime:线程没有任务时最多保持多长时间后会终止
 *
 *
 * @author han yao
 * @date 2020/11/12 下午1:23
 */
public class ThreadPoolTest {
    public static void main(String[] args){
        // 1. 提供指定线程数量的线程池（Excutors下还有别的线程池创建
        ExecutorService service1 = Executors.newFixedThreadPool(10);
        // 2. 设置线程池的属性
        System.out.println(service1.getClass());
        //
        ThreadPoolExecutor service = (ThreadPoolExecutor) service1;
        service.setCorePoolSize(5); // 线程池的基本大小，即在没有任务需要执行的时候线程池的大小
        service.setMaximumPoolSize(10);  //线程池中允许的最大线程数，线程池中的当前线程数目不会超过该值
//        service.setKeepAliveTime();

        // 3. 执行指定的线程操作，需要提供实现Runable/Callable接口
        service.execute(new NumberThread()); //需要实现Runable接口的run()， 没有返回值

        service.submit(new NumberThread1()); //需要实现Callable接口的call(), 有返回值

        // 4. 关闭线程池
        service.shutdown();
    }
}


class NumberThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i <= 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}


class NumberThread1 implements Callable {
    @Override
    public Object call() throws Exception {
        for(int i = 0; i <= 100; i++){
            if(i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
        return null;
    }
}