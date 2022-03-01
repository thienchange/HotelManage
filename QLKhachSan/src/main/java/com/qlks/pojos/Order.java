/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.pojos;

/**
 *
 * @author ACER
 */
public class Order {
    private int dichVuId;
    private String tenDvu;
    private Long giaDvu;
    private int soDvu;

    /**
     * @return the dichVuId
     */
    public int getDichVuId() {
        return dichVuId;
    }

    /**
     * @param dichVuId the dichVuId to set
     */
    public void setDichVuId(int dichVuId) {
        this.dichVuId = dichVuId;
    }

    /**
     * @return the tenDvu
     */
    public String getTenDvu() {
        return tenDvu;
    }

    /**
     * @param tenDvu the tenDvu to set
     */
    public void setTenDvu(String tenDvu) {
        this.tenDvu = tenDvu;
    }

    /**
     * @return the giaDvu
     */
    public Long getGiaDvu() {
        return giaDvu;
    }

    /**
     * @param giaDvu the giaDvu to set
     */
    public void setGiaDvu(Long giaDvu) {
        this.giaDvu = giaDvu;
    }

    /**
     * @return the soDvu
     */
    public int getSoDvu() {
        return soDvu;
    }

    /**
     * @param soDvu the soDvu to set
     */
    public void setSoDvu(int soDvu) {
        this.soDvu = soDvu;
    }
}
