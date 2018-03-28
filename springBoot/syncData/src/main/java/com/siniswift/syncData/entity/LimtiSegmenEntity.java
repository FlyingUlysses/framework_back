package com.siniswift.syncData.entity;


public class LimtiSegmenEntity {
    private String limitType;

    private String codePointStart;

    private String codeFirStart;

    private String codeIcaoStart;

    private String codeTypeStart;

    private String codePointEnd;

    private String codeFirEnd;

    private String codeIcaoEnd;

    private String codeTypeEnd;

    private String txtDesig;

    private String notamInfoId;

    public String getLimitType() {
        return limitType;
    }

    public void setLimitType(String limitType) {
        this.limitType = limitType == null ? null : limitType.trim();
    }

    public String getCodePointStart() {
        return codePointStart;
    }

    public void setCodePointStart(String codePointStart) {
        this.codePointStart = codePointStart == null ? null : codePointStart.trim();
    }

    public String getCodeFirStart() {
        return codeFirStart;
    }

    public void setCodeFirStart(String codeFirStart) {
        this.codeFirStart = codeFirStart == null ? null : codeFirStart.trim();
    }

    public String getCodeIcaoStart() {
        return codeIcaoStart;
    }

    public void setCodeIcaoStart(String codeIcaoStart) {
        this.codeIcaoStart = codeIcaoStart == null ? null : codeIcaoStart.trim();
    }

    public String getCodeTypeStart() {
        return codeTypeStart;
    }

    public void setCodeTypeStart(String codeTypeStart) {
        this.codeTypeStart = codeTypeStart == null ? null : codeTypeStart.trim();
    }

    public String getCodePointEnd() {
        return codePointEnd;
    }

    public void setCodePointEnd(String codePointEnd) {
        this.codePointEnd = codePointEnd == null ? null : codePointEnd.trim();
    }

    public String getCodeFirEnd() {
        return codeFirEnd;
    }

    public void setCodeFirEnd(String codeFirEnd) {
        this.codeFirEnd = codeFirEnd == null ? null : codeFirEnd.trim();
    }

    public String getCodeIcaoEnd() {
        return codeIcaoEnd;
    }

    public void setCodeIcaoEnd(String codeIcaoEnd) {
        this.codeIcaoEnd = codeIcaoEnd == null ? null : codeIcaoEnd.trim();
    }

    public String getCodeTypeEnd() {
        return codeTypeEnd;
    }

    public void setCodeTypeEnd(String codeTypeEnd) {
        this.codeTypeEnd = codeTypeEnd == null ? null : codeTypeEnd.trim();
    }

    public String getTxtDesig() {
        return txtDesig;
    }

    public void setTxtDesig(String txtDesig) {
        this.txtDesig = txtDesig == null ? null : txtDesig.trim();
    }

    public String getNotamInfoId() {
        return notamInfoId;
    }

    public void setNotamInfoId(String notamInfoId) {
        this.notamInfoId = notamInfoId == null ? null : notamInfoId.trim();
    }
}