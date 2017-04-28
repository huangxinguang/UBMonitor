package com.ectrip.common;

import com.ectrip.vo.OptRecordAndEnvVO;

import java.util.List;

/**
 * Created by huangxinguang on 2017/4/28 下午4:01.
 * desc:搜索结果集
 */
public class SearchResult {
    /**
     * 结果数据
     */
    private List<OptRecordAndEnvVO> rows;
    /**
     * 总共记录数
     */
    private Long total;

    public SearchResult() {
    }

    public SearchResult(List<OptRecordAndEnvVO> rows, Long total) {
        this.rows = rows;
        this.total = total;
    }

    public List<OptRecordAndEnvVO> getRows() {
        return rows;
    }

    public void setRows(List<OptRecordAndEnvVO> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
