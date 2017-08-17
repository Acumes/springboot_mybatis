package com.htf.mapper;

import java.io.Serializable;

/**
 * Created by PC-FENG on 2017/8/17.
 */

public interface BaseMapper <T extends Serializable , ID extends Serializable> {
    int deleteByPrimaryKey(ID id);
    int insert(T record);
    T selectByPrimaryKey(ID id);
    int updateByPrimaryKey(T record);
}
