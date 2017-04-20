package com.ectrip.dao;

import com.ectrip.model.OptEnvironment;

import java.util.List;

/**
 * Created by Administrator on 2017/4/20 0020.
 *
 */
public interface OptEnvironmentDAO {

    List<OptEnvironment> getOptRecordInfo();

    void save(OptEnvironment optEnvironment);
}
