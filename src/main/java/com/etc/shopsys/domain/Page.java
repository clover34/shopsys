package com.etc.shopsys.domain;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO
 * @Author Administrator
 * @Date 20/09/30 15:33
 * @Version 1.0
 **/
public class Page<T> {
    private int currentPage;// 当前页
    private int prevPage;// 上一页
    private int nextPage;// 下一页
    private int sizePage;// 页面显示记录数
    private int totalCount;// 总记录数
    private int totalPage;// 总页数
    private List<T> data;// 数据

    public Page(int currentPage, int sizePage, int totalCount, List<T> data) {
        this.currentPage = currentPage;
        this.sizePage = sizePage;
        this.totalCount = totalCount;
        this.data = data;
        this.totalPage = totalCount % sizePage > 0 ? totalCount / sizePage + 1 : totalCount / sizePage;
        this.prevPage = currentPage - 1 > 0 ? currentPage - 1 : 1;
        this.nextPage = currentPage + 1 < totalPage ? currentPage + 1 : totalPage;
    }

    public Page() {
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", prevPage=" + prevPage +
                ", nextPgge=" + nextPage +
                ", sizePage=" + sizePage +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }

    // get & set 方法
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPgge) {
        this.nextPage = nextPgge;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
