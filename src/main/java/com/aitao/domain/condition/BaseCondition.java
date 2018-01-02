package com.aitao.domain.condition;



public class BaseCondition {

    /* 请求地址 */
    private int pageSize = 0;
    private int pageNum;
    private int skipResults = 0;

    private String orderBy;
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        skipResults = pageSize * pageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        skipResults = pageSize * pageNum;
    }

    public int getSkipResults() {
        return skipResults;
    }


    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    /*
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    */
}
