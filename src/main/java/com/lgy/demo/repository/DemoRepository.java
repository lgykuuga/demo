package com.lgy.demo.repository;

import com.lgy.common.repository.AbstractRepository;
import com.lgy.demo.bean.DemoBean;

import java.util.List;

public interface DemoRepository extends AbstractRepository<DemoBean> {

    public List<DemoBean> findAllByGnaLike(String gna);

}
