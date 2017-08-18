package com.htf.util;

/**
 * Created by PC-FENG on 2017/8/18.
 */
public class FilterOrderAndPage<T> {
    private PagesInfo<T> page;
    private FilterAndOrder fao;

    public PagesInfo<T> getPage() {
        return page;
    }
    public void setPage(PagesInfo<T> page) {
        this.page = page;
    }
    public FilterAndOrder getFao() {
        return fao;
    }
    public void setFao(FilterAndOrder fao) {
        this.fao = fao;
    }
}