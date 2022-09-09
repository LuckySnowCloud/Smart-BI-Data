package com.yun.bidataconnmon.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yun
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "";

    /**
     * 返回代码
     */
    private Integer code = 200;
    /**
     * 返回数据对象 data
     */
    private T result;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public Result() {
    }

    /**
     * 兼容VUE3版token失效不跳转登录页面
     *
     * @param code
     * @param message
     */
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result<T> SUCCESS(String message) {
        this.message = message;
        this.code = ResultEnum.SUCCESS.respCode;
        this.success = true;
        return this;
    }


    public static <T> Result<T> OK() {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultEnum.SUCCESS.respCode);
        return r;
    }

    public static <T> Result<T> OK(String msg) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultEnum.SUCCESS.respCode);
        r.setMessage(msg);
        r.setResult((T) msg);
        return r;
    }

    public static <T> Result<T> OK(T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultEnum.SUCCESS.respCode);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> OK(String msg, T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(true);
        r.setCode(ResultEnum.SUCCESS.respCode);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> ERROR(String msg, T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(false);
        r.setCode(ResultEnum.ERROR.respCode);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> ERROR(ResultEnum resultEnum, T data) {
        Result<T> r = new Result<T>();
        r.setSuccess(false);
        r.setCode(resultEnum.respCode);
        r.setMessage(resultEnum.respDesc);
        r.setResult(data);
        return r;
    }

    public static <T> Result<T> ERROR(ResultEnum resultEnum) {
        Result<T> r = new Result<T>();
        r.setSuccess(false);
        r.setCode(resultEnum.respCode);
        r.setMessage(resultEnum.respDesc);
        r.setResult(null);
        return r;
    }

    public static Result<Object> ERROR(String msg) {
        return ERROR(ResultEnum.ERROR.respCode, msg);
    }

    public static Result<Object> ERROR(int code, String msg) {
        Result<Object> r = new Result<Object>();
        r.setCode(code);
        r.setMessage(msg);
        r.setSuccess(false);
        return r;
    }

    public enum ResultEnum {
        //定义返回值内容
        SUCCESS(200, "处理成功"),
        ERROR(500, "处理失败"),
        DIRTY_DATA(200001, "存在脏数据"),
        ROLE_TOKEN_DOES_NOT_EXIST(200002, "角色获取Token失败"),
        NO_SUCH_DATA_PROCESSING_TYPE(100002, "无此数据处理类型!"),
        INTERFACE_DOES_NOT_EXIST(100001, "接口不存在!");
        private Integer respCode;
        private String respDesc;

        ResultEnum(Integer respCode, String respDesc) {
            this.respCode = respCode;
            this.respDesc = respDesc;
        }

        public Integer getRespCode() {
            return respCode;
        }

        public String getRespDesc() {
            return respDesc;
        }
    }

}
