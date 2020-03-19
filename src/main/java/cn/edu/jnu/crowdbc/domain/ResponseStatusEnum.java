package cn.edu.jnu.crowdbc.domain;

public enum ResponseStatusEnum implements BaseErrorInfoInterface{
    SUCCESS(200,"成功！"),
    BODY_NOT_MATCH(400,"请求格式不符合要求！"),
    SIGNATURE_NOT_MATCH(401,"数字签名并不匹配！"),
    NOT_FOUND(404,"未找到该资源！"),
    INTERNAL_SERVER_ERROR(500,"服务器内部错误！"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试！"),
    DEPOLY_FAILURE(600,"部署失败！");
    private int code;
    private String msg;

    ResponseStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    @Override
    public int getResultCode() {
        return this.code;
    }

    @Override
    public String getResultMsg() {
        return this.msg;
    }
}
