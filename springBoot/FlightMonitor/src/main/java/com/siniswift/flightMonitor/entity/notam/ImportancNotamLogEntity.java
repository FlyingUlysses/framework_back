package com.siniswift.flightMonitor.entity.notam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * IMPORTANC_NOTAM_LOG
 * @author 
 */
public class ImportancNotamLogEntity implements Serializable {
    private Long importancNotamLogId;

    private String cnvctype;

    private String cnvcapproachmode;

    private String cnvcapproachname;

    private String cnvcairportcode;

    private String cnvcrunwayname;

    private String keyType;

    private String cndtstart1;

    private String cndtstart2;

    private String cnvcstarttype;

    private String cndtend1;

    private String cndtend2;

    private String cnvcendtype;

    private BigDecimal cnitradius;

    private String points;

    private Date cndtstarttime;

    private Date cndtendtime;

    private String enttimeAux;

    private String cndtdtime;

    private Long notamId;

    private Date recpTime;

    private String showComment;

    private String status;

    private String isimportantnotam;

    private String replacenotam;

    private Short valFlight;

    private Short valHorcs;

    private String isValid;

    private Short logStatus;

    private Short isUpdatedHorcs;

    private Short isUpdatedFlight;

    private String logInfo;

    private Date dateLastmodify;

    private String timeType;

    private String codeNotam;

    private String nof;

    private String isDeleted;

    private String userLastmodify;

    private String cndaircraft;

    private String cndwingspan;

    private String cndwingspantype;

    private String cndnavaidcode;

    private String cndnavaidtype;

    private String cndtraffic;

    private String cndweight;

    private String cndrwylength;

    private String cndfuel;

    private String cndfirelevel1;

    private String cndfirelevel2;

    private String itemFLower;

    private String itemGUpper;

    private String snowF;

    private String snowG;

    private String snowH;

    private String telex;

    private static final long serialVersionUID = 1L;

    public Long getImportancNotamLogId() {
        return importancNotamLogId;
    }

    public void setImportancNotamLogId(Long importancNotamLogId) {
        this.importancNotamLogId = importancNotamLogId;
    }

    public String getCnvctype() {
        return cnvctype;
    }

    public void setCnvctype(String cnvctype) {
        this.cnvctype = cnvctype;
    }

    public String getCnvcapproachmode() {
        return cnvcapproachmode;
    }

    public void setCnvcapproachmode(String cnvcapproachmode) {
        this.cnvcapproachmode = cnvcapproachmode;
    }

    public String getCnvcapproachname() {
        return cnvcapproachname;
    }

    public void setCnvcapproachname(String cnvcapproachname) {
        this.cnvcapproachname = cnvcapproachname;
    }

    public String getCnvcairportcode() {
        return cnvcairportcode;
    }

    public void setCnvcairportcode(String cnvcairportcode) {
        this.cnvcairportcode = cnvcairportcode;
    }

    public String getCnvcrunwayname() {
        return cnvcrunwayname;
    }

    public void setCnvcrunwayname(String cnvcrunwayname) {
        this.cnvcrunwayname = cnvcrunwayname;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public String getCndtstart1() {
        return cndtstart1;
    }

    public void setCndtstart1(String cndtstart1) {
        this.cndtstart1 = cndtstart1;
    }

    public String getCndtstart2() {
        return cndtstart2;
    }

    public void setCndtstart2(String cndtstart2) {
        this.cndtstart2 = cndtstart2;
    }

    public String getCnvcstarttype() {
        return cnvcstarttype;
    }

    public void setCnvcstarttype(String cnvcstarttype) {
        this.cnvcstarttype = cnvcstarttype;
    }

    public String getCndtend1() {
        return cndtend1;
    }

    public void setCndtend1(String cndtend1) {
        this.cndtend1 = cndtend1;
    }

    public String getCndtend2() {
        return cndtend2;
    }

    public void setCndtend2(String cndtend2) {
        this.cndtend2 = cndtend2;
    }

    public String getCnvcendtype() {
        return cnvcendtype;
    }

    public void setCnvcendtype(String cnvcendtype) {
        this.cnvcendtype = cnvcendtype;
    }

    public BigDecimal getCnitradius() {
        return cnitradius;
    }

    public void setCnitradius(BigDecimal cnitradius) {
        this.cnitradius = cnitradius;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Date getCndtstarttime() {
        return cndtstarttime;
    }

    public void setCndtstarttime(Date cndtstarttime) {
        this.cndtstarttime = cndtstarttime;
    }

    public Date getCndtendtime() {
        return cndtendtime;
    }

    public void setCndtendtime(Date cndtendtime) {
        this.cndtendtime = cndtendtime;
    }

    public String getEnttimeAux() {
        return enttimeAux;
    }

    public void setEnttimeAux(String enttimeAux) {
        this.enttimeAux = enttimeAux;
    }

    public String getCndtdtime() {
        return cndtdtime;
    }

    public void setCndtdtime(String cndtdtime) {
        this.cndtdtime = cndtdtime;
    }

    public Long getNotamId() {
        return notamId;
    }

    public void setNotamId(Long notamId) {
        this.notamId = notamId;
    }

    public Date getRecpTime() {
        return recpTime;
    }

    public void setRecpTime(Date recpTime) {
        this.recpTime = recpTime;
    }

    public String getShowComment() {
        return showComment;
    }

    public void setShowComment(String showComment) {
        this.showComment = showComment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsimportantnotam() {
        return isimportantnotam;
    }

    public void setIsimportantnotam(String isimportantnotam) {
        this.isimportantnotam = isimportantnotam;
    }

    public String getReplacenotam() {
        return replacenotam;
    }

    public void setReplacenotam(String replacenotam) {
        this.replacenotam = replacenotam;
    }

    public Short getValFlight() {
        return valFlight;
    }

    public void setValFlight(Short valFlight) {
        this.valFlight = valFlight;
    }

    public Short getValHorcs() {
        return valHorcs;
    }

    public void setValHorcs(Short valHorcs) {
        this.valHorcs = valHorcs;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public Short getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Short logStatus) {
        this.logStatus = logStatus;
    }

    public Short getIsUpdatedHorcs() {
        return isUpdatedHorcs;
    }

    public void setIsUpdatedHorcs(Short isUpdatedHorcs) {
        this.isUpdatedHorcs = isUpdatedHorcs;
    }

    public Short getIsUpdatedFlight() {
        return isUpdatedFlight;
    }

    public void setIsUpdatedFlight(Short isUpdatedFlight) {
        this.isUpdatedFlight = isUpdatedFlight;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public Date getDateLastmodify() {
        return dateLastmodify;
    }

    public void setDateLastmodify(Date dateLastmodify) {
        this.dateLastmodify = dateLastmodify;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }

    public String getCodeNotam() {
        return codeNotam;
    }

    public void setCodeNotam(String codeNotam) {
        this.codeNotam = codeNotam;
    }

    public String getNof() {
        return nof;
    }

    public void setNof(String nof) {
        this.nof = nof;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUserLastmodify() {
        return userLastmodify;
    }

    public void setUserLastmodify(String userLastmodify) {
        this.userLastmodify = userLastmodify;
    }

    public String getCndaircraft() {
        return cndaircraft;
    }

    public void setCndaircraft(String cndaircraft) {
        this.cndaircraft = cndaircraft;
    }

    public String getCndwingspan() {
        return cndwingspan;
    }

    public void setCndwingspan(String cndwingspan) {
        this.cndwingspan = cndwingspan;
    }

    public String getCndwingspantype() {
        return cndwingspantype;
    }

    public void setCndwingspantype(String cndwingspantype) {
        this.cndwingspantype = cndwingspantype;
    }

    public String getCndnavaidcode() {
        return cndnavaidcode;
    }

    public void setCndnavaidcode(String cndnavaidcode) {
        this.cndnavaidcode = cndnavaidcode;
    }

    public String getCndnavaidtype() {
        return cndnavaidtype;
    }

    public void setCndnavaidtype(String cndnavaidtype) {
        this.cndnavaidtype = cndnavaidtype;
    }

    public String getCndtraffic() {
        return cndtraffic;
    }

    public void setCndtraffic(String cndtraffic) {
        this.cndtraffic = cndtraffic;
    }

    public String getCndweight() {
        return cndweight;
    }

    public void setCndweight(String cndweight) {
        this.cndweight = cndweight;
    }

    public String getCndrwylength() {
        return cndrwylength;
    }

    public void setCndrwylength(String cndrwylength) {
        this.cndrwylength = cndrwylength;
    }

    public String getCndfuel() {
        return cndfuel;
    }

    public void setCndfuel(String cndfuel) {
        this.cndfuel = cndfuel;
    }

    public String getCndfirelevel1() {
        return cndfirelevel1;
    }

    public void setCndfirelevel1(String cndfirelevel1) {
        this.cndfirelevel1 = cndfirelevel1;
    }

    public String getCndfirelevel2() {
        return cndfirelevel2;
    }

    public void setCndfirelevel2(String cndfirelevel2) {
        this.cndfirelevel2 = cndfirelevel2;
    }

    public String getItemFLower() {
        return itemFLower;
    }

    public void setItemFLower(String itemFLower) {
        this.itemFLower = itemFLower;
    }

    public String getItemGUpper() {
        return itemGUpper;
    }

    public void setItemGUpper(String itemGUpper) {
        this.itemGUpper = itemGUpper;
    }

    public String getSnowF() {
        return snowF;
    }

    public void setSnowF(String snowF) {
        this.snowF = snowF;
    }

    public String getSnowG() {
        return snowG;
    }

    public void setSnowG(String snowG) {
        this.snowG = snowG;
    }

    public String getSnowH() {
        return snowH;
    }

    public void setSnowH(String snowH) {
        this.snowH = snowH;
    }

    public String getTelex() {
        return telex;
    }

    public void setTelex(String telex) {
        this.telex = telex;
    }
}