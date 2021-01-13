package com.jiming.daily.domain;

/**
 * 功能：模拟的返回数据bean
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class Q6250002AckData extends AckData {

    private String cusId;

    private String cusName;

    private String certificateCode;

    private String mobile;

    private String district;

    private String street;

    private String nativePlaceCode;

    private String nativePlace;

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNativePlaceCode() {
        return nativePlaceCode;
    }

    public void setNativePlaceCode(String nativePlaceCode) {
        this.nativePlaceCode = nativePlaceCode;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Q6250002AckData{");
        sb.append("cusId='").append(cusId).append('\'');
        sb.append(", cusName='").append(cusName).append('\'');
        sb.append(", certificateCode='").append(certificateCode).append('\'');
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", district='").append(district).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", nativePlaceCode='").append(nativePlaceCode).append('\'');
        sb.append(", nativePlace='").append(nativePlace).append('\'');
        sb.append('}');
        return sb.toString();
    }
}