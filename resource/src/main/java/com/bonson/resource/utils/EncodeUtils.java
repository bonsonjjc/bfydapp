package com.bonson.resource.utils;

import android.util.Log;

import com.bonson.library.utils.LogUtils;
import com.bonson.library.utils.security.Base64;
import com.google.gson.Gson;

import java.util.Map;

public class EncodeUtils {
    public static byte[] encodeAes(byte[] bytes) {
        return AesUtils.encode(bytes);
    }

    public static byte[] decodeAes(byte[] bytes) {
        return AesUtils.decode(bytes);
    }

    public static String encodeAesToString(String str) {
        return new String(AesUtils.encode(str.getBytes()));
    }

    public static String decodeAesToString(String str) {
        return new String(AesUtils.decode(str.getBytes()));
    }


    public static byte[] encodeBase64(byte[] bytes) {
        return Base64.encode(bytes).getBytes();
    }

    public static byte[] decodeBase64(byte[] bytes) {
        byte[] decode = Base64.decode(new String(bytes));
        return decode;
    }

    public static String encodeBase64ToString(String bytes) {
        String encode = Base64.encode(bytes.getBytes());
        return encode;
    }

    public static String encodeBase64ToString(byte[] bytes) {
        String encode = Base64.encode(bytes);
        return encode;
    }

    public static String decodeBase64ToString(String bytes) {
        byte[] decode = Base64.decode(bytes);
        return new String(decode);
    }

    public static String decodeBase64ToString(byte[] bytes) {
        return Base64.decodeString(new String(bytes));
    }

    public static String encode(String json) {
        LogUtils.e("加密:"+json);
        return AesUtils.encodeBase64(json);
    }


    public static Gson gson = new Gson();

    public static String encode(Map bytes) {
        String json = gson.toJson(bytes);
        return encode(json);
    }

    public static String decode(String bytes) {
        String str = AesUtils.decodeBase64(bytes);
        LogUtils.e("解码:"+str);
        return str;
    }

}
