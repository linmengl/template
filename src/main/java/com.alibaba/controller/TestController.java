package com.alibaba.controller;

import com.alibaba.model.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ResponseBody
@RequestMapping("/html")
//@Slf4j
public class TestController  {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     *
     * @return
     */
    @RequestMapping(value = "/a")
    public JsonResult testList() {
        logger.info("访问成功","haha");
        return JsonResult.buildSuccessResult("success",null);
    }

}
