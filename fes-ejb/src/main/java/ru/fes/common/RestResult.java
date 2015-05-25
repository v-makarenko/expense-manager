package ru.fes.common;

/**
 * Created by VMakarenko on 2/15/15.
 */
public class RestResult {
    private String status;
    private String errorCode;
    private Object data;

    public RestResult(){}
    private RestResult(String status) {
        this.status = status;
    }

    public static RestResult getOk(){
        return new RestResult(AppConsts.RESPONSE_OK);
    }

    public static RestResult getBad(){
        return new RestResult(AppConsts.RESPONSE_ERROR);
    }

    public RestResult data(Object data ){
        this.data = data;
        return this;
    }

    public RestResult errorCode(String errorCode){
        this.errorCode = errorCode;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
