package com.kushal.jwt.jwt.example.model;

import java.util.List;

public class Result<T> {
    private List<String> message;
    private T result;

    public Result() {
        super();
    }

    public List<String> getMessage() {
        return message;
    }

    public Result<T> setMessage(List<String> message) {
        this.message = message;
        return this;
    }

    public T getResult() {
        return result;
    }

    public Result<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public Result(List<String> message, T result) {
        this.message = message;
        this.result = result;
    }
}
