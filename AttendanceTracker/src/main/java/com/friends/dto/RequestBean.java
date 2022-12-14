package com.friends.dto;

public class RequestBean {


    private String key;
    private String iv;
    private String plainText;


    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getIv() {
        return iv;
    }
    public void setIv(String iv) {
        this.iv = iv;
    }
    public String getPlainText() {
        return plainText;
    }
    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }
    @Override
    public String toString() {
        return "RequestBean [key=" + key + ", iv=" + iv + ", plainText=" + plainText + "]";
    }


}