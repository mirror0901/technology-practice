package com.mirror.base.designmode.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: mirror
 * @date: 2020/4/20 16:49
 * @description:
 */
public class App1 implements Observer {


    Observable observable;
    private float temperature;

    public App1(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData wd = (WeatherData) o;
            this.temperature = wd.getTemperature();
            display();
        }
    }

    public void display() {
        System.out.println("当前温度：" + this.temperature + "摄氏度");
    }

    public static void main(String[] args) {
        //实例化主题
        WeatherData wd = new WeatherData();
        //实例化观察者，并传入主题
        App1 app1 = new App1(wd);
        //每次改变温度时，都会通知观察者更新输出。
        wd.setTemperature(20);
        wd.setTemperature(22);
    }

}
