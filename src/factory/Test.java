package factory;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 工厂方法模式：有四个角色，抽象工厂模式，具体工厂模式，抽象产品模式，具体产品模式。
 * 不再是由一个工厂类去实例化具体的产品，而是由抽象工厂的子类去实例化产品
 * @create: 2020-04-24 00:01
 **/
public class Test {

    public static void main(String[] args) {
        VehicleFactory factory = new BroomFactory();
        Moveable moveable = factory.create();
        moveable.run();
    }

}
