package design.pattern.singleton;

public class Singleton {
    // 1. 私有化构造器
    public int a;
    private Singleton(){
        a = 1;
    }
    // 2. 内部提供一个当前类的实例, 且为static
    private static Singleton single = new Singleton();
    // 3. 用public且 static的类方法返回static的实例
    public static Singleton getInstance(){
        return single;
    }
}