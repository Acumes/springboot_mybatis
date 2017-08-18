package com.htf.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.google.common.base.Strings;
/**
 * 多列筛选、查询、及排序<br>
 * 和Mapper配合使用，前端感知SQL的各列名，Mapper使用传入的此对象来完成多列的筛选、查询、及排序<br>
 * set时已为各个keywords前后添加%以进行模糊匹配<br>
 * set时已为各个columnName前后加上了`符号<br>
 * 列名只能由0-9、a-z、A-Z、和英文句号及下划线组成<br>
 * Created by PC-FENG on 2017/8/18.
 */
public class FilterAndOrder {
    private static final Pattern validChecker = Pattern.compile("[\\w.]+");
    private String searchKeyword;
    private List<String> searchColumnNames;
    private List<FilterItem> filterItems;
    private List<OrderItem> orderItems;

    /**
     * 检查合法性，防止SQL注入
     *
     * @param labelNames
     */
    private static void checkColumnName(String columnName) {
        if (!validChecker.matcher(columnName).matches())
            throw new IllegalArgumentException("Invalid SQL label name:\t" + columnName);
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    /**
     * 多列模糊搜索关键词，与searchColumnNames配合使用
     *
     * @param searchKeyword
     */
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = Strings.isNullOrEmpty(searchKeyword) ? null : '%' + replaceKeyValue(searchKeyword) + '%';
    }

    public List<String> getSearchColumnNames() {
        return searchColumnNames;
    }

    /**
     * 多列模糊搜索-搜索列，与searchKeyword配合使用<br>
     * 此方法会copy一个list
     *
     * @param searchColumnNames
     */
    public void setSearchColumnNames(List<String> searchColumnNames) {
        List<String> cns;
        if (searchColumnNames != null && !searchColumnNames.isEmpty()) {
            cns = new ArrayList<>(searchColumnNames.size());
            for (String l : searchColumnNames){
                checkColumnName(l);
                cns.add('`'+l+'`');
            }
        }else
            cns = Collections.emptyList();
        this.searchColumnNames = cns;
    }

    public List<FilterItem> getFilterItems() {
        return filterItems;
    }

    public void setFilterItems(List<FilterItem> filterItems) {
        this.filterItems = filterItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * 筛选器
     *
     * @author trytocatch
     * @date 2016年8月25日
     */
    public static class FilterItem {
        private String columnName;
        private String keywords;

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            checkColumnName(columnName);
            this.columnName = '`'+columnName+'`';
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = Strings.isNullOrEmpty(keywords) ? null : '%' + replaceKeyValue(keywords) + '%';
        }

        public void setKeywordsWithoutPercent(String keywords) {
            this.keywords = Strings.isNullOrEmpty(keywords) ? null : keywords;
        }
    }

    /**
     * 排序器
     *
     * @author trytocatch
     * @date 2016年8月25日
     */
    public static class OrderItem {
        private String columnName;
        private boolean asc;

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            checkColumnName(columnName);
            this.columnName = '`'+columnName+'`';
        }

        public boolean isAsc() {
            return asc;
        }

        public void setAsc(boolean asc) {
            this.asc = asc;
        }
    }

    /**
     * 将\、_、%转义
     * @param keyValue
     * @return
     */
    public static String replaceKeyValue(String keyValue) {
        return keyValue.replace("\\", "\\\\").replace("_", "\\_").replace("%", "\\%");
    }

}