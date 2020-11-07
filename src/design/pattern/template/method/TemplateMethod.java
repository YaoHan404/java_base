package design.pattern.template.method;

/*
抽象类的应用
 */
public class TemplateMethod {
    public static void main(String[] args){
        Template t = new SubTemplate();
        t.spendTime();
    }
}



abstract class Template{
    //计算某段代码执行所需要的时间
    public void spendTime(){
        long start = System.currentTimeMillis();
        testTimeCode(); //不确定的部分，易变化的部分
        long end = System.currentTimeMillis();
        System.out.println("代码运行时间：" + (end - start));
    }
    public abstract void testTimeCode();
}


class SubTemplate extends Template{
    @Override
    public void testTimeCode() { // 计算质数
        for(int i = 2; i <= 1000; i++){
            boolean isFlag = true;
            for(int j = 2; j<=Math.sqrt(i) ;j++){
                if(i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag){
                System.out.println(i);
            }
        }
    }
}