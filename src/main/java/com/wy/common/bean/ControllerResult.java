package com.wy.common.bean;

/**
 * Created by Administrator on 2/15/2017.
 */
public class ControllerResult {

    public static final int SUCCESS_CODE = 100;
    public static final int FAIL_CODE = 101;
    public static final String SUCCESS_RESULT = "success";
    public static final String FAIL_RESULT = "fail";

    private int code;
    private String result;
    private String message;
    private String roleName;


    public ControllerResult(int code, String result, String message) {
        this.code = code;
        this.result = result;
        this.message = message;
    }

    public ControllerResult(int code, String result, String message,String roleName) {
        this.code = code;
        this.result = result;
        this.message = message;
        this.roleName=roleName;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "ControllerResult{" +
                "code='" + code + '\'' +
                ", result='" + result + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static ControllerResult getSuccessResult(String message) {
        return new ControllerResult(ControllerResult.SUCCESS_CODE, ControllerResult.SUCCESS_RESULT, message);
    }

    public static ControllerResult getLoginRsult(String message,String roleName){
        return new ControllerResult(ControllerResult.SUCCESS_CODE, ControllerResult.SUCCESS_RESULT, message,roleName);
    }

    public static ControllerResult getFailResult(String message) {
        return new ControllerResult(ControllerResult.FAIL_CODE, ControllerResult.FAIL_RESULT, message);
    }
}
