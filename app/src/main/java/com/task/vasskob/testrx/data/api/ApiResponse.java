package com.task.vasskob.testrx.data.api;

import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> {
    @SerializedName("result")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
