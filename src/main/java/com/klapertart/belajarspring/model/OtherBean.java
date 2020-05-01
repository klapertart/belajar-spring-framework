package com.klapertart.belajarspring.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author otongsunandar
 * @since 22/04/20
 */

// implementasi ApplicationContextAware berfungsi untuk meng-inject context ke class
public class OtherBean implements ApplicationContextAware {
    private DataBean dataBean;
    private SampleBean sampleBean;
    private ApplicationContext context;

    public OtherBean(DataBean dataBean, SampleBean sampleBean) {
        this.dataBean = dataBean;
        this.sampleBean = sampleBean;
    }

    public DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public SampleBean getSampleBean() {
        return sampleBean;
    }

    public void setSampleBean(SampleBean sampleBean) {
        this.sampleBean = sampleBean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void doHello(String name){
        SayHello data = context.getBean(SayHello.class);
        String sapa = data.hello(name);
        System.out.println(sapa);
    }
}
