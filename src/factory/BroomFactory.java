package factory;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-24 00:13
 **/
public class BroomFactory extends VehicleFactory {

    @Override
    public Moveable create() {
        return new Broom();
    }

}
