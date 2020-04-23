package factory;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description: 具体工厂
 * @create: 2020-04-24 00:11
 **/
public class PlaneFactory extends VehicleFactory {

    @Override
    Moveable create() {
        return new Plane();
    }

}
