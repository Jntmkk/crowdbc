package cn.edu.jnu.crowdbc.domain;

import java.util.ArrayList;
import java.util.List;

public class ResponseBody<T> {
    private int code;
    private String msg;

    public ResponseBody(BaseErrorInfoInterface info) {
        this.code = info.getResultCode();
        this.msg = info.getResultMsg();
    }

    public ResponseBody(int code, String msg) {
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

    private List<T> data = new ArrayList<>();


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
