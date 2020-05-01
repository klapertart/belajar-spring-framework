package com.klapertart.belajarspring.model;

/**
 * @author otongsunandar
 * @since 22/04/20
 */
public class SampleBean {
    private DataBean dataBean;

    public SampleBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(DataBean dataBean) {
        this.dataBean = dataBean;
    }
}
