package com.helpdeskproject.utils;

import org.json.JSONObject;

public class ResponseFormatter {
    public static String SendResponse(String status, String message) {
        JSONObject resp = new JSONObject();
        resp.put("message", message);
        resp.put("status", status);
        return resp.toString();
    }

    public static String SendSuccessResponse(String status, String message, String token) {
        JSONObject resp = new JSONObject();
        resp.put("status", status);
        resp.put("message", message);
        resp.put("token", token);
        return resp.toString();
    }
}