package factory.factory.method;

/*
工厂方法
想获得产品，customer要求抽象factory下的subFactory去制造
缺点： 每一种产品都需要有一个subFactory，当产品种类非常庞大时，就要有一大堆subFactory
解决方案： 对于subFactory，不是只生产一种产品，而是多写一点函数，再让customer去调用 --->>> 抽象工厂
 */

public class FactoryMethod {
    public static void main(String[] args){
        Customer customer = new Customer();
        customer.buyCar();
    }
}


/*
复杂产品
 */
abstract class BatteryPack{
}
class BigBatteryPack extends BatteryPack{
    public BigBatteryPack(){
        System.out.println("Choose a big battery pack.");
    }
}
class SmallBatteryPack extends BatteryPack{
    public SmallBatteryPack(){
        System.out.println("Choose a small battery pack.");
    }
}

abstract class Motor{
}
class SingleMotor extends Motor{
    public SingleMotor(){
        System.out.println("Choose one motor version.");
    }
}
class DoubleMotor extends Motor{
    public DoubleMotor(){
        System.out.println("Choose two motors version.");
    }
}

abstract class Autopilot{
}
class SimpleAutopilot extends Autopilot{
    public SimpleAutopilot(){
        System.out.println("Choose a simple autopilot");
    }
}
class AdvancedAutopilot extends Autopilot{
    public AdvancedAutopilot(){
        System.out.println("Choose an advanced autopilot");
    }
}


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
    abstract BatteryPack ChooseBatteryPack();
    abstract Motor ChooseMotor();
    abstract Autopilot ChooseAutopilot();
}
// 工厂子类
class FactoryModel3 extends Factory{
    @Override
    public Tesla makeTesla(){
        return new Model3();
    }

    @Override
    BatteryPack ChooseBatteryPack() {
        return new SmallBatteryPack();
    }

    @Override
    Motor ChooseMotor() {
        return new SingleMotor();
    }

    @Override
    Autopilot ChooseAutopilot() {
        return new SimpleAutopilot();
    }
}
class FactoryModelS extends Factory{
    @Override
    public Tesla makeTesla(){
        return new ModelS();
    }

    @Override
    BatteryPack ChooseBatteryPack() {
        return new BigBatteryPack();
    }

    @Override
    Motor ChooseMotor() {
        return new DoubleMotor();
    }

    @Override
    Autopilot ChooseAutopilot() {
        return new AdvancedAutopilot();
    }
}

/*
客户
 */

class Customer{
    public void buyCar(){
        Factory factoryModel3 = new FactoryModel3();
        factoryModel3.makeTesla();
        factoryModel3.ChooseBatteryPack();
        factoryModel3.ChooseMotor();
        factoryModel3.ChooseAutopilot();
        Factory factoryModelS = new FactoryModelS();
        factoryModelS.makeTesla();
        factoryModelS.ChooseBatteryPack();
        factoryModelS.ChooseMotor();
        factoryModelS.ChooseAutopilot();
    }
}
