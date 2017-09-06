package com.htf.util;

/**
 * Created by PC-FENG on 2017/9/6.
 */
public class PageRequest {
    private  int pageSize = 10;
    private  int pageNum = 1;

    private String searchKeyWord;
    private OrderItem orderItem;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getSearchKeyWord() {
        return "%"+ searchKeyWord + "%";
    }

    public void setSearchKeyWord(String searchKeyWord) {
        this.searchKeyWord = searchKeyWord;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    /**
     * 加上asc或desc, 拼接成sql中使用的排序语句，如果失败则返回null
     * @param request
     * @return
     */
    public static String getOrderSql(PageRequest request){
        if(request == null || request.getOrderItem() == null)
            return null;
        String orderBy = request.getOrderItem().getColumnName();
        if(orderBy == null || orderBy.isEmpty())
            return null;
        if(request.getOrderItem().isAsc())
            return orderBy.concat(" asc");
        else
            return orderBy.concat(" desc");
    }
}
