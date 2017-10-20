package com.htf.util;

/**
 * Created by PC-FENG on 2017/10/20.
 */
public enum Status {

    /**
     * 待激活
     *
     * @since 0.3
     */
    PreActive(0),

    /**
     * 正常状态用户
     *
     * @since 0.3
     */
    Enabled(1),

    /**
     * 被禁用, 针对应用场景中的用户离职后，用户不让其登录，但其资料依然可被查看
     *
     * @since 0.3
     */
    Disabled(-1),

    /**
     * 被删除
     *
     * @since 0.3
     */
    Deleted(-2);

    private int code;

    private Status(int code) {
        this.code = code;
    }

    /**
     * 返回状态码
     *
     * @return 状态码[-1|0|1]
     */
    public int getCode() {
        return code;
    }

}

