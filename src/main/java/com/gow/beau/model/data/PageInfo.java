package com.gow.beau.model.data;

import lombok.Data;

import java.util.List;

/**
 * Created by lzn on 2019/6/26.
 * 分页
 */
@Data
public class PageInfo {

    // 符合条件的记录总数
    private int rows;
    // 总页数
    private int totalPages;
    // 每页显示多少条
    private int pageSize = 10;
    // 当前页码
    private int pageNo = 1;
    // 分页开始的条数
    private int startRowNum;
    // 分页结束的条数
    private int endRowNum;
    //当前页码
    private String currentPage;

    //存储单个返回的结果对象
    private Object resultBean;
    //存储当前的数据列表
    private List<?> list;

    public PageInfo(){}

    //根据页码计算开始和结束位置
    public PageInfo(Integer pageNo){
        if(null == pageNo || pageNo == 0 || pageNo < 0){
            pageNo = 1;
        }else{
            this.setPageNo(pageNo);
        }
        this.setStartRowNum((pageNo - 1) * pageSize);
        this.setEndRowNum(pageSize);
    }

    /**
     * 根据总条数计算页数
     * */
    public void setRows(int rows) {
        int totalPages = rows / 10;
        int row = rows % 10;
        if (row > 0) {
            totalPages = totalPages + 1;
        }
        this.setTotalPages(totalPages);
        this.rows = rows;
    }

    /**
     * 根据每页查询的条数计算
     * */
    public void setPageSize(int pageSize) {
        if(pageNo == 0 || pageNo < 0){
            pageNo = 1;
        }
        this.setStartRowNum((pageNo-1) * pageSize);
        this.setEndRowNum(pageSize);
    }

}
