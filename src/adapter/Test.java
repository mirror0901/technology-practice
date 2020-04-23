package adapter;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-04-23 23:38
 **/
public class Test {

    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();
    }
}

class Phone {
    //正常电压 220V，是一个常量
    public static final int V = 220;
    private VoltageAdapter adapter;

    //充电
    public void charge() {
        adapter.changeVoltage();
    }

    public void setAdapter(VoltageAdapter voltageAdapter) {
        this.adapter = voltageAdapter;
    }

}

//变压器
class VoltageAdapter {
    //改变电压的功能
    public void changeVoltage() {
        System.out.println("正在充电……");
        System.out.println("原始电压:" + Phone.V + "V");
        System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
    }
}
