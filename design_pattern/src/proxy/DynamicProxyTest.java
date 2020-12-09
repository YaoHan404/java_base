package proxy;

/**
 *
 * 动态代理的举例
 *
 * @author han yao
 * @date 2020/12/1 21:28
 */


interface Human{
    String getBelief();
    void eat(String food);
}


// 被代理类
class SuperMan implements Human{
    @Override
    public String getBelief(){
        return "我相信我会飞";
    }
    @Override
    public void eat(String food){
        System.out.println("我喜欢吃" + food);
    }
}





public class DynamicProxyTest {
    public static void main(String[] args){

    }
}
