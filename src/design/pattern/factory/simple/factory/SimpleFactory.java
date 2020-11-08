package design.pattern.factory.simple.factory;

/*
简单工厂模式
想获得产品，customer要求factory去制造（customer只需要指定哪一个产品，factory负责产品的创建过程）
缺点： factory不符合开闭原则(对扩展开放, 对修改封闭),每增加一种新的产品，就需要修改factory的代码，
     增加创建新产品的代码（比如增加case）（尤其是产品比较复杂时，这种增加会很麻烦很混乱）
解决方案：将一个factory改为多个factory，每个factory只负责一个产品（这样就不需要修改factory的代码，
     在增加新的产品时，只需要扩展一个factory，符合开笔笔原则）--->>> 工厂方法
 */

public class SimpleFactory {
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
工厂
 */

class Factory{
    public Tesla makeTesla(String type){
        switch (type) {
            case "Model3":
                return new Model3();
            case "ModelS":
                return new ModelS();
            default:
                return null;
        }
    }
}


/*
客户
 */

class Customer{
    public void buyCar(){
        Factory factory = new Factory();
        Tesla model3 = factory.makeTesla("Model3");
        Tesla models = factory.makeTesla("ModelS");
    }
}