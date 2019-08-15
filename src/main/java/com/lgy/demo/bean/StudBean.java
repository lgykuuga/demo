package com.lgy.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lgy.common.domain.AbstractBean;
import org.springframework.data.elasticsearch.annotations.Document;

@TableName("stud")
@Document(indexName = "stud")
public class StudBean extends AbstractBean {

    private static final long serialVersionUID = 1L;

    private String gco;
    private String gna;
    private Integer age;
    private String mail;
    /**
     * 上级学号
     */
    private String pgco;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPgco() {
        return pgco;
    }

    public void setPgco(String pgco) {
        this.pgco = pgco;
    }

    @Override
    public String toString() {
        return "StudBean{" +
                "gco='" + gco + '\'' +
                ", gna='" + gna + '\'' +
                ", age=" + age +
                ", mail='" + mail + '\'' +
                ", pgco='" + pgco + '\'' +
                '}';
    }
}
