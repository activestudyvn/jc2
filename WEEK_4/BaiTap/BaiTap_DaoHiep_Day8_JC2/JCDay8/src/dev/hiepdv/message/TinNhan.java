/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.hiepdv.message;

import java.util.Date;

/**
 *
 * @author Hell
 */
public class TinNhan {
    private String thueBao;
    private String noiDung;
    private Date thoiGianGui;
    private String dauSo;

    public String getThueBao() {
        return thueBao;
    }

    public void setThueBao(String soDT) {
        this.thueBao = soDT;
    }

    public String getNdTin() {
        return noiDung;
    }

    public void setNdTin(String ndTin) {
        this.noiDung = ndTin;
    }

    public Date getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(Date thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getDauSo() {
        return dauSo;
    }

    public void setDauSo(String dauSo) {
        this.dauSo = dauSo;
    }
    
}
