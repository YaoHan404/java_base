package design.pattern.singleton;

/*
使用同步机制将单例模式中的懒汉模式改写为线程安全的
 */

public class SingletonSynchronized {
}

class Bank{
    private Bank(){}
    private static Bank instance = null;

    public static Bank getInstance(){
        if(instance == null){
            instance = new Bank(); // 如果不增加线程安全，这里可能会被多个线程调用到，多次new
        }
        return instance;
    }
}

class BankSafe{
    private BankSafe(){}
    private static BankSafe instance = null;
    //用synchronized锁把方法同步
    public static synchronized BankSafe getInstance(){
        if(instance == null){
            instance = new BankSafe(); // 如果不增加线程安全，这里可能会被多个线程调用到，多次new
        }
        return instance;
    }
}

class BankSafe1{
    private BankSafe1(){}
    private static BankSafe1 instance = null;

    public static BankSafe1 getInstance(){
        //用synchronized锁把代码块同步
        //效率稍差，因为这里只有new BankSafe是需要注意安全的，而return instance则不需要
        synchronized (BankSafe1.class) {
            if (instance == null) {
                instance = new BankSafe1(); // 如果不增加线程安全，这里可能会被多个线程调用到，多次new
            }
            return instance;
        }
    }
}

class BankSafe2{
    private BankSafe2(){}
    private static BankSafe2 instance = null;

    public static BankSafe2 getInstance(){
        //用synchronized锁把代码块同步
        //高效方法
        if(instance == null) {
            synchronized (BankSafe2.class) {
                if (instance == null) {
                    instance = new BankSafe2(); // 如果不增加线程安全，这里可能会被多个线程调用到，多次new
                }
            }
        }
        return instance;
    }
}