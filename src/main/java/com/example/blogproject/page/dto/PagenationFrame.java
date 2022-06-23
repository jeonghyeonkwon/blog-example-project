package com.example.blogproject.page.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagenationFrame <T>{
    private boolean isFirst;
    private boolean isLast;
    private int currentPage;
    private int totalPage;
    private long totalElement;
    private int startBlockPage;
    private int endBlockPage;
    private List<T> dataList;

    public PagenationFrame(
            int currentPage,
            boolean isFirst,
            boolean isLast,
            int totalPage,
            long totalElements,
            List<T> dataList
    ){
        this.currentPage = currentPage;
        this.isFirst = isFirst;
        this.isLast = isLast;
        this.totalPage = totalPage;
        this.totalElement = totalElements;
        this.dataList = dataList;
        this.startBlockPage = ((currentPage)/10)*10+1;
        int endBlock = this.startBlockPage+9;
        endBlock = totalPage < endBlock ? totalPage : endBlock;
        this.endBlockPage = endBlock;

    }
}
