package com.lgx.vo;

/**
 * 返回信息封装
 * @author LGX_TvT
 * @date 2019-01-20 0:10
 */
public class ResultInfo {
    private int code;
    private String msg;
    private String info;

    public ResultInfo() {
    }

    public ResultInfo(int code, String msg, String info) {
        this.code = code;
        this.msg = msg;
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
