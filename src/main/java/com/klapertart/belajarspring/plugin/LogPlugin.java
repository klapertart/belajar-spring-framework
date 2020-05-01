package com.klapertart.belajarspring.plugin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

/**
 * @author otongsunandar
 * @since 25/04/20
 */
@Component
public class LogPlugin extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Telah dibuat sebuah bean dengan nama " + beanName +
                " dengan tipe " + bean.getClass().getName());
        return bean;
    }
}
