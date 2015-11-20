package com.langeye.common;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.List;

/**
 * Created by Fish on 2015/11/6.
 */
public class Pager<E> {
    private int page;
    private int pageSize;
    private int totalRecord;
    private int pageCount;
    private int nextPage;
    private int prevPage;
    private List<E> records;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<E> getRecords() {
        return records;
    }

    public void setRecords(List<E> records) {
        this.records = records;
    }

    public int getPageCount(){
        pageCount =totalRecord%pageSize>0?(totalRecord/pageSize+1):totalRecord/pageSize;
        return pageCount;
    }

    public int getNextPage(){
        return page + 1==  pageCount ? pageCount:page+1;
    }

    public int getPrevPage(){
        return page -1==0?page:page-1;
    }
}
