package com.nghinv.beddingsellintroduce.common.Dto.web;

import lombok.*;

import java.io.Serializable;

/**
 * TẠo ra class này chỉ để lưu giữ thông tin
 */


public class Info implements Serializable {
    String key;
    String value;

    public Info(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    public Info() {
//
//    }
//
//    public Info(String key, String value) {
//        this.key = key;
//        this.value = value;
//    }
}
