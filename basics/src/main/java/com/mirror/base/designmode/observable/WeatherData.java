package com.mirror.base.designmode.observable;

import java.util.Observable;

/**
 * @author: mirror
 * @date: 2020/4/20 16:47
 * @description:
 */
public class WeatherData extends Observable {

    private float temperature;

    public void tempChanged() {
        setChanged();
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        tempChanged();
    }

}
