package com.ectrip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huangxinguang on 2017/4/19 下午4:14.
 * </p>
 * Desc:
 */
public abstract class BaseController {

    private final static Logger _log = LoggerFactory.getLogger(BaseController.class);

    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }
}
