package com.jbetfairng;

import java.util.Map;

public class JsonRequest {

    public String jsonrpc = "2.0";
    public String method;
    public int id;
    public Map<String, Object> params;

    public JsonRequest() { }
}
