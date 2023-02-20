package com.yautumn.common.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Getter
@Setter
public class PageBeanUtil<T> {
    private Integer currentPage;//当前页
    private Integer startIndex;//起始页
    private Integer pageSize;//每页显示数据数量
    private Integer totalCount;//数据总数
    private Integer totalPage;//最大页数
    private List<T> list;//数据内容
    private int start;
    private int end;

    public PageBeanUtil(Integer currentPage, Integer pageSize, Integer totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        if (totalCount % pageSize == 0){
            this.totalPage = totalCount / pageSize;
        }else {
            this.totalPage = totalCount / pageSize + 1;
        }
        this.startIndex = (currentPage-1)*pageSize;

        this.start = 1;
        this.end = 5;

        if (totalPage <= 5){
            this.end = totalPage;
        }else {
            this.start = currentPage - 2;
            this.end = currentPage + 2;

            if (start < 0){
                this.start = 1;
                this.end = 5;
            }
            if(end > totalPage){
                this.end = totalPage;
                this.start = totalPage - 5;
            }
        }

    }
}
