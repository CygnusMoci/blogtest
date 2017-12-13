package com.moci.blogtest.entity.BO;

/**
 * 用于返回前端的各种对象
 * @author moci
 * @create 2017-12-13 2:45 PM
 **/
public class RestResponseBo<T> {

    /**
     * 服务器响应数据
     */
    private T payload;

    /**
     * 请求是否成功
     */
    private boolean success;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 状态码
     */
    private int code =-1;

    private long timestamp;

    /**
     *适用于各类构造函数,实际上应该由需求来进行扩展,用到的时候会逐一写出
     */
    public RestResponseBo(){
        this.timestamp = System.currentTimeMillis()/1000;
    }

    public RestResponseBo(boolean success){
        this.timestamp = System.currentTimeMillis()/1000;
        this.success = success;
    }

    public RestResponseBo(boolean success, T payload, int code){
        this.timestamp = System.currentTimeMillis()/1000;
        this.success = success;
        this.payload = payload;
        this.code = code;
    }
    public RestResponseBo(boolean success, String msg){
        this.timestamp = System.currentTimeMillis()/1000;
        this.success = success;
        this.msg = msg;
    }

    public RestResponseBo(boolean success, String msg, int code) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.msg = msg;
        this.code = code;
    }
    public static RestResponseBo ok() {
        return new RestResponseBo(true);
    }

    public static RestResponseBo fail(){
        return new RestResponseBo(false,"账号或密码错误");
    }


    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
