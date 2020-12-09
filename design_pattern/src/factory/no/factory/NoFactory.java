package factory.no.factory;

/*
没有工厂模式
想获得产品，customer只能自己去new。没有工厂去生产，要自行获取
缺点：customer和产品高度耦合。客户需要完成某一个产品的创建过程
    （有的复杂产品不是new一个对象可以完成的，可能额外需要获取一堆参数进行设置，或者需要new一些辅助的对象
      所以，需要让customer避开产品的创建过程）
解决方案：将产品的创建放入工厂，customer只需要告诉工厂需要哪一个产品 --->>> 简单工厂模式
 */

public class NoFactory {
    public static void main(String[] args){
        Customer customer = new Customer();
        customer.buyCar();
    }
}

/*
产品
 */
abstract class Tesla{
}

class Model3 extends Tesla{
    public Model3(){
        System.out.println("Make a model3");
    }
}

class ModelS extends Tesla{
    public ModelS(){
        System.out.println("Make a ModelS");
    }
}

/*
客户
 */

class Customer{
    public void buyCar(){
        Tesla model3 = new Model3();
        Tesla modelS = new ModelS();
    }
}
