package cn.edu.jnu.crowdbc.config;

import lombok.Data;

import java.util.Date;

@Data
public class Result<T> {
    private long timestamp;
    private String message;
    private int code = 200;
    private T data;


    public Result(String message, int code, T data) {
        this.message = message;
        this.data = data;
        this.timestamp = new Date().getTime();
    }

    public static <K> Object error(K k) {
        return new Result<K>("error", 500, k);

    }

    public static <K> Object success(K k) {
        return new Result<K>("success", 200, k);
    }

//    public static <K> Object build(K k) {
//        return new Result<k>()
//    }
//
//    @Data
//    public static class Builder<T> {
//        //部分代码略
//    }
}
