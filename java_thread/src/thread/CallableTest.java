package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 多线程方式三：实现Callable接口
 *
 * @author han yao
 * @date 2020/11/12 上午10:26
 */
public class CallableTest {
    public static void main(String[] args){
        // 3. 创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        // 4. 将Callable接口实现类的对象传到FutureTask构造器嗯，
        // FutureTask 同时实现了Runnable, Future接口
        FutureTask futureTask = new FutureTask(numThread);
        // 5. 将FutureTask对象传到Thread构造器中，启动线程
        new Thread(futureTask).start();

        try{
            // 5. get()返回值，即Callable重写的call()的返回，但不是它启动的call()
            Object sum = futureTask.get();
            System.out.println(sum);
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
    }
}


// 1. 实现Callable接口
class NumThread implements Callable{
    @Override
    // 2. 实现call()方法，线程需要的操作写在call()中
    //  有return(支持泛型)， 可抛出Exceprtion
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            System.out.println(sum);
        }
        return sum; //这里会把int自动装箱Integer
    }
}




