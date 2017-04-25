package com.jbetfairng;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class JsonResponse<T> {
    public String jsonRpc;
    public T result;
    // exceptions error;
    public Object id;
    public Boolean hasError;

    public Type getRealType() {
        return TypeToken.get(new JsonResponse<T>().getClass()).getType();
    }
}
