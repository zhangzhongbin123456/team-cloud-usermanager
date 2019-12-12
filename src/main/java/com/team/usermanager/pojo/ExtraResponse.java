package com.team.usermanager.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author: Created By Zzbin
 * @date: 2019/12/12
 * Generic returns a wrapper class with arguments
 */
@JsonPropertyOrder({"error_code", "error_msg", "extra"})
public class ExtraResponse extends BaseResponse {

    @JsonProperty("extra")
    public Object extra;

    public ExtraResponse() {
        super();
    }

    public ExtraResponse(BaseResponse baseResponse, Object extra) {
        super(baseResponse.errorCode, baseResponse.errorMsg);
        this.extra = extra;
    }

    public ExtraResponse(Object extra) {
        this(BaseResponse.SUCCESS, extra);
    }

    public ExtraResponse(Integer errorCode, String errorMsg, Object extra) {
        this(new BaseResponse(errorCode, errorMsg), extra);
    }

}
