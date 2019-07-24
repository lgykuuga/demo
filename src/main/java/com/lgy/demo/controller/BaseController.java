package com.lgy.demo.controller;


import com.lgy.common.controller.AbstractController;
import com.lgy.demo.bean.BaseBean;
import com.lgy.demo.bean.DemoBean;
import com.lgy.demo.service.IBaseService;
import com.lgy.demo.service.IDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/base")
@Api("Base Controller模块")
public class BaseController extends AbstractController<BaseBean, IBaseService> {

    @Resource
    IBaseService baseService;

}
