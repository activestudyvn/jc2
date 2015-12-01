/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thuantd.vn;

/**
 *
 * @author ThuanTD
 */
public class Message {
    private String msisdn;
    private String content;
    private String time;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String soDienThoai) {
        this.msisdn = soDienThoai;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String noiDung) {
        this.content = noiDung;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String thoiGian) {
        this.time = thoiGian;
    }
    
    
}
