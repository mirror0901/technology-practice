package factory;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 具体产品角色
 * @create: 2020-04-24 00:04
 **/
public class Plane implements Moveable {

    @Override
    public void run() {
        System.out.println("plane……");
    }

}
