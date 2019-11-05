package com.qf.util;

public class PageInfoUtils {
    public static PageInfo getPageInfo(int apage,Long totalcount){

       int size = DataUtils.PAGESIZE;

       long ltotalcount = totalcount;
       int inttotalcount = (int)ltotalcount;

       int pages = inttotalcount%size>0?inttotalcount/size+1:inttotalcount/size;

       int offset = (apage-1)*size;

       PageInfo pageInfo = new PageInfo(apage,size,pages,inttotalcount,offset);
       return pageInfo;
    }
}
