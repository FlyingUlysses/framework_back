package com.siniswift.syncData.entity;


public class NotamInfoEntity {
    private String notamInfoId;

    private String notamName;

    private String notamNof;

    private String notamB;

    private String notamC1;

    private String notamC2;

    private String notamD;

    private String txtNotamInfo;

    private String passState;

    private String txtUsername;

    private String isCancel;

    public String getNotamInfoId() {
        return notamInfoId;
    }

    public void setNotamInfoId(String notamInfoId) {
        this.notamInfoId = notamInfoId == null ? null : notamInfoId.trim();
    }

    public String getNotamName() {
        return notamName;
    }

    public void setNotamName(String notamName) {
        this.notamName = notamName == null ? null : notamName.trim();
    }

    public String getNotamNof() {
        return notamNof;
    }

    public void setNotamNof(String notamNof) {
        this.notamNof = notamNof == null ? null : notamNof.trim();
    }

    public String getNotamB() {
        return notamB;
    }

    public void setNotamB(String notamB) {
        this.notamB = notamB == null ? null : notamB.trim();
    }

    public String getNotamC1() {
        return notamC1;
    }

    public void setNotamC1(String notamC1) {
        this.notamC1 = notamC1 == null ? null : notamC1.trim();
    }

    public String getNotamC2() {
        return notamC2;
    }

    public void setNotamC2(String notamC2) {
        this.notamC2 = notamC2 == null ? null : notamC2.trim();
    }

    public String getNotamD() {
        return notamD;
    }

    public void setNotamD(String notamD) {
        this.notamD = notamD == null ? null : notamD.trim();
    }

    public String getTxtNotamInfo() {
        return txtNotamInfo;
    }

    public void setTxtNotamInfo(String txtNotamInfo) {
        this.txtNotamInfo = txtNotamInfo == null ? null : txtNotamInfo.trim();
    }

    public String getPassState() {
        return passState;
    }

    public void setPassState(String passState) {
        this.passState = passState == null ? null : passState.trim();
    }

    public String getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(String txtUsername) {
        this.txtUsername = txtUsername == null ? null : txtUsername.trim();
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel == null ? null : isCancel.trim();
    }
}