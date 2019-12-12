package com.team.usermanager.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * @author: Created By Zzbin
 * @date: 2019/12/12
 * Generic returned wrapper class
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    public static final int CODE_SUCCESS = 1000;
    public static final int CODE_INVALID_PARAM = 1001;
    public static final int CODE_SYSTEM_BUSY = 1002;
    public static final int CODE_FAIL = 1003;
    public static final int CODE_COMMON = 1099;

    public static final BaseResponse SUCCESS = new BaseResponse(CODE_SUCCESS, "成功");
    public final static BaseResponse INVALID_PARAM = new BaseResponse(CODE_INVALID_PARAM, "参数错误");
    public static final BaseResponse SYSTEM_BUSY = new BaseResponse(CODE_SYSTEM_BUSY, "系统忙，请稍后再试(1002)");
    public static final BaseResponse FAIL = new BaseResponse(CODE_FAIL, "请求失败");

    @SerializedName("error_code")
    @JsonProperty("error_code")
    protected Integer errorCode;

    @SerializedName("error_msg")
    @JsonProperty("error_msg")
    protected String errorMsg;

    public BaseResponse() {
        this(BaseResponse.SUCCESS);
    }

    public BaseResponse(BaseResponse response) {
        this(response.errorCode, response.errorMsg);
    }

    public BaseResponse(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static BaseResponse invalidParam(String paramName) {
        return new BaseResponse(CODE_COMMON, paramName);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return (this.errorCode == CODE_SUCCESS);
    }

    @Override
    public String toString() {
        return "BaseResponse [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
    }
}
