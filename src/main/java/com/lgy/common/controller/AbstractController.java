package com.lgy.common.controller;

import com.lgy.common.service.AbstractService;
import com.lgy.common.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

public abstract class AbstractController<T, Service extends AbstractService<T>> {

    public Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    protected Service service;

    @ResponseBody
    @RequestMapping(value = {"/save"}, method = {RequestMethod.POST})
    public Message save(@Valid T t, Errors errors) {
        logger.debug("Start execute save operation[{}]", t.toString());
        Integer res = service.save(t);
        return res == 1 ? new Message("保存成功", true) : new Message("保存失败", false);
    }

    @ResponseBody
    @RequestMapping(value = {"/delete"}, method = {RequestMethod.POST})
    public Message delete(@RequestParam String ids) {
        logger.debug("Start execute delete operation[{}]", ids);
        if (ids != null) {
            Integer count = service.deleteByIds(ids);
            if (count != null && count.intValue() > 0) {
                logger.debug("it successed to delete");
                return new Message("删除" + count + "条数据", true);
            }
        }
        logger.debug("删除数据失败,请检查数据信息[{}]", ids);
        return new Message("删除数据失败,请检查数据信息", true);
    }

    @ResponseBody
    @RequestMapping(value = {"/update"}, method = {RequestMethod.POST})
    public Message update(@Valid T t, Errors errors) {
        logger.debug("Start execute update operation[{}]", t.toString());
        Integer res = service.updateColumnsAll(t);
        return res == 1 ? new Message("修改成功", true) : new Message("修改失败", false);
    }

    @ResponseBody
    @RequestMapping("/findOne")
    public T findOne(@RequestParam Long id) {
        logger.debug("Start execute findOne operation with id[{}]", id);
        return service.findOne(id);
    }

}
