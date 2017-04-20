package com.ectrip.dao;

import com.ectrip.model.OptRecord;

/**
 * Created by huangxinguang on 2017/4/19 下午3:33.
 * </p>
 * Desc:
 */
public interface OptRecordDAO {
    /**
     * 根据指定条件查询用户操作记录以及操作时用户环境
     * @param optRecord
     */
    OptRecord findOptRecordInfo(OptRecord optRecord);
    public void save(OptRecord optRecord);
}
