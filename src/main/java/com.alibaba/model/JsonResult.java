package com.alibaba.model;

import com.alibaba.Constants;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
@Setter
public class JsonResult implements Serializable {

    private static final Long SUCCESS_CODE = 0L;

    private static final Long ERROR_STATE_CODE = 1L;

    private static final Long SUCCESS_BUSSINESS_CODE = 0L;

    private static final Long ERROR_BUSSINESS_CODE = 1L;

    private static final long serialVersionUID = -1L;

    private String msg = "";

    // 0成功，1失败
    private String code = "0000";

    // 业务错误码
    private String businessCode = "0000";

    private Object data = null;

    public JsonResult() {
    }

    /**
     * @param msg
     * @param code
     * @param data
     */
    public JsonResult(String msg, Long code, Object data) {
        this.msg = msg;
        this.code = String.format(Constants.ZERO_FILL_TEMPLATE, code);
        this.data = data;
    }

    public JsonResult(String msg, Long code, Object data, Long businessCode) {
        this.msg = msg;
        this.code = String.format(Constants.ZERO_FILL_TEMPLATE, code);
        this.data = data;
        this.businessCode = String.format(Constants.ZERO_FILL_TEMPLATE, businessCode);
    }

    /**
     * 构造成功的JsonResult
     *
     * @param msg  String
     * @param data Object
     * @return JsonResult
     */
    public static JsonResult buildSuccessResult(String msg, Object data) {
        return new JsonResult(msg, SUCCESS_CODE, data, SUCCESS_BUSSINESS_CODE);
    }

    public static JsonResult buildSuccessResult(String msg) {
        return new JsonResult(msg, SUCCESS_CODE, null, SUCCESS_BUSSINESS_CODE);
    }

    public static JsonResult buildSuccessResult(String msg, Object data, Long bussinessId) {
        return new JsonResult(msg, SUCCESS_CODE, data, bussinessId);
    }

    /**
     * 构造状态不正确的JsonResult
     *
     * @param msg  String
     * @param data Object
     * @return JsonResult
     */
    public static JsonResult buildErrorStateResult(String msg, Object data) {
        return new JsonResult(msg, SUCCESS_CODE, data, ERROR_BUSSINESS_CODE);
    }

    public static JsonResult buildErrorStateResult(String msg, Object data, Long busniessId) {
        return new JsonResult(msg, SUCCESS_CODE, data, busniessId);
    }

    public static JsonResult buildFatalErrorStateResult(String msg, Object data, Long busniessId) {
        return new JsonResult(msg, ERROR_STATE_CODE, data, busniessId);
    }


    /**
     * 判断当前JsonResult是否是成功
     *
     * @return true=是成功,false=失败
     */
    public boolean isSuccess() {
        boolean codeSuccess = String.format(Constants.ZERO_FILL_TEMPLATE, SUCCESS_CODE).equals(this.getCode());
        boolean bussSuccess = String.format(Constants.ZERO_FILL_TEMPLATE, SUCCESS_BUSSINESS_CODE).equals(this.getBusinessCode());
        return bussSuccess && codeSuccess;
    }


}
