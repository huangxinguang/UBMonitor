package com.ectrip.service;

import com.ectrip.model.OptRecord;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by huangxinguang on 2017/4/20 下午2:18.
 * </p>
 * Desc:
 */
public interface OptManageService {

    /**
     * 根据指定条件查询用户操作记录以及操作时的用户环境
     * @param optRecord
     */
    OptRecord findOptRecordInfo(OptRecord optRecord);

    /**
     * 保存用户操作，和操作环境
     * @param optRecord
     */
    void saveOptAndEnv(HttpServletRequest request,OptRecord optRecord);
}
