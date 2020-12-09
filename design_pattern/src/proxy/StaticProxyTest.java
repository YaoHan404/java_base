package proxy;

/**
 * 静态代理举例
 *
 * 特点：代理类和被代理类在编译时就确定了
 *
 * @author han yao
 * @date 2020/12/1 21:20
 */

// 代理类 和 被代理类 的接口
interface ClothFactory{
    void produceCloth();
}


//被代理类
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth(){
        System.out.println("被代理工厂生产运动服");
    }
}


//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory; // 对 被代理对象 进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth(){
        System.out.println("代理工厂前处理");
        factory.produceCloth();  // 调用 被代理对象 的方法
        System.out.println("代理工厂后处理");
    }
}


public class StaticProxyTest {
    public static void main(String[] args){
        // 创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        // 创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);  // 被代理类硬编码，写死在代码里

        proxyClothFactory.produceCloth();
    }
}
