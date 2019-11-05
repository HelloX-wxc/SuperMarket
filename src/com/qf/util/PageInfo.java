package com.qf.util;

public class PageInfo {

    //分页工具类
    private int apage;
    private int size;
    private int pages;
    private int totalcount;
    private int offset;

    @Override
    public String toString() {
        return "PageInfo{" +
                "apage=" + apage +
                ", size=" + size +
                ", pages=" + pages +
                ", totalcount=" + totalcount +
                ", offset=" + offset +
                '}';
    }

    public int getApage() {
        return apage;
    }

    public void setApage(int apage) {
        this.apage = apage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public PageInfo(int apage, int size, int pages, int totalcount, int offset) {
        this.apage = apage;
        this.size = size;
        this.pages = pages;
        this.totalcount = totalcount;
        this.offset = offset;
    }

    public PageInfo() {
    }
}
