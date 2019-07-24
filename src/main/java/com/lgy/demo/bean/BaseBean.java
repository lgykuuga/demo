package com.lgy.demo.bean;

import com.lgy.common.bean.AbstractBean;


public class BaseBean extends AbstractBean {

    private static final long serialVersionUID = 1L;

    private String gco;
    private String gna;

    public String getGco() {
        return gco;
    }

    public void setGco(String gco) {
        this.gco = gco;
    }

    public String getGna() {
        return gna;
    }

    public void setGna(String gna) {
        this.gna = gna;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "gco='" + gco + '\'' +
                ", gna='" + gna + '\'' +
                '}';
    }
}
