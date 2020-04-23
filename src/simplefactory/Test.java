package simplefactory;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 简单工厂模式：一个抽象的接口，多个抽象接口的实现类，一个工厂类，用来实例化抽象的接口
 * @create: 2020-04-23 23:46
 **/
interface Car {

    void run();

    void stop();

}

class Benz implements Car {

    @Override
    public void run() {
        System.out.println("benz 开始启动了……");
    }

    @Override
    public void stop() {
        System.out.println("benz 停车了……");
    }
}


class Ford implements Car {

    @Override
    public void run() {
        System.out.println("ford 开始启动了……");
    }

    @Override
    public void stop() {
        System.out.println("ford 停车了……");
    }

}

// 工厂类
class Factory {
    public static Car getCarInstance(String type) {
        Car c = null;
        if ("Benz".equals(type)) {
            c = new Benz();
        } else if ("Ford".equals(type)) {
            c = new Ford();
        }
        return c;
    }
}

public class Test {

    public static void main(String[] args) {
        Car c = Factory.getCarInstance("Benz");
        if (c!=null){
            c.run();
            c.stop();
        }else {
            System.out.println("造不了这种汽车……");
        }
    }

}




