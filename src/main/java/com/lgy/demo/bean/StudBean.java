package com.lgy.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.bean.AbstractBean;

@TableName("stud")
public class StudBean extends AbstractBean {

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
        return "StudBean{" +
                "gco='" + gco + '\'' +
                ", gna='" + gna + '\'' +
                '}';
    }
}
