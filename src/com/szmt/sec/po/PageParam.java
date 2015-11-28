package com.szmt.sec.po;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-11-11.
 */
public class PageParam {
    private List rows;  //数据
//    private int page = 1;   //请求页
//    private int numOfList = 10;   //显示行数
    private int total;  //数据总数

//    public PageParam() {
//        this(new ArrayList(), 1, 10, 20);
//    }


    public PageParam() {
    }

    public PageParam(List rows,  int total) {
        this.rows = rows;
//        this.page = page;
//        this.numOfList = numOfList;
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

//    public int getPage() {
//        return page;
//    }

//    public void setPage(int page) {
//        this.page = page;
//    }

//    public int getNumOfList() {
//        return numOfList;
//    }

//    public void setNumOfList(int numOfList) {
//        this.numOfList = numOfList;
//    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
