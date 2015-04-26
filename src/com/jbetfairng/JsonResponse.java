package com.jbetfairng;

public class JsonResponse<T> {
    public String jsonRpc;
    public T result;
    // exceptions error;
    public Object id;
    public Boolean hasError;
}
