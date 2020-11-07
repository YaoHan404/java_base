package design.pattern.singleton;

/*
这种方法存在多线程安全的问题
但是可以修复
 */

public class Singleton2 {
    // 1. 私有化构造器
    public int a;
    private Singleton2(){
        a = 1;
    }
    // 2. 内部提供一个当前类的实例, 且为static
    private static Singleton2 single;
    // 3. 用public且 static的类方法返回static的实例
    public static Singleton2 getInstance(){
        if(single == null){
            single = new Singleton2();
        }
        return single;
    }
}