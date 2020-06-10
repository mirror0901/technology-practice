package com.mirror.base.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author: mirror
 * @date: 2020/6/10 15:54
 * @description:
 */
public class OrderEvent extends ApplicationEvent {

    private String message;

    public OrderEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }
}
