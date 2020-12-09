package factory.abstractfactory;

public class AbstractFactory {
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

class Model3 extends Tesla {
    public Model3(){
        System.out.println("Make a model3");
    }
}

class ModelS extends Tesla {
    public ModelS(){
        System.out.println("Make a ModelS");
    }
}

/*
工厂
 */

// 抽象工厂类

abstract class Factory{
    abstract Tesla makeTesla();
}
// 工厂子类
class FactoryModel3 extends Factory {
    public Tesla makeTesla(){
        return new Model3();
    }
}
class FactoryModelS extends Factory {
    public Tesla makeTesla(){
        return new ModelS();
    }
}

/*
客户
 */

class Customer{
    public void buyCar(){
        Factory factoryModel3 = new FactoryModel3();
        factoryModel3.makeTesla();
        Factory factoryModelS = new FactoryModelS();
        factoryModelS.makeTesla();
    }
}
