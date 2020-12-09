package reflection.test;

/**
 * @author han yao
 * @date 2020/11/30 18:44
 */
public class Person {
    private String name;
    public int age;

    @Override
    public String toString(){
        return "Person{" + "name='" +name + "\'" + ",age=" + age + "}";
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("我是一个人");
    }

    public String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
