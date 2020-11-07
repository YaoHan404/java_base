package design.pattern;
import design.pattern.*;
import design.pattern.singleton.Singleton;

public class DesignPatternTest {
    public static void main(String[] args){
        Singleton single1 = Singleton.getInstance();
        System.out.println(single1.a);
        single1.a = 2;
        System.out.println(single1.a);
        Singleton single2 = Singleton.getInstance();
        System.out.println(single2.a);
        System.out.println("xxx");
    }
}
