package com.siniswift.flightMonitor.entity.flight;

import java.io.Serializable;
import java.util.Date;

/**
 * FLIGHT_INFO
 * @author 
 */
public class FlightInfoEntity implements Serializable {
    private String flightInfoId;

    private Date flightDate;

    private String flightNo;

    private String departureAirport;

    private String departureAbbr;

    private String arrivalAirport;

    private String arrivalAbbr;

    private Date std;

    private Date sta;

    private String aircraftType;

    private String regCode;

    private Date etd;

    private Date atd;

    private Date eta;

    private Date ata;

    private String div1airport4code;

    private String div2airport4code;

    private String div1cityname;

    private String div2cityname;

    private Short valMadepac;

    private Short valUploadpac;

    private Date boardingtime;

    private Date closingtime;

    private String passengers;

    private String dep3code;

    private String arr3code;

    private String releaseId;

    private Short cancelflight;

    private Long crewLinkLine;

    private Long stewLinkLine;

    private static final long serialVersionUID = 1L;

    public String getFlightInfoId() {
        return flightInfoId;
    }

    public void setFlightInfoId(String flightInfoId) {
        this.flightInfoId = flightInfoId;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureAbbr() {
        return departureAbbr;
    }

    public void setDepartureAbbr(String departureAbbr) {
        this.departureAbbr = departureAbbr;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalAbbr() {
        return arrivalAbbr;
    }

    public void setArrivalAbbr(String arrivalAbbr) {
        this.arrivalAbbr = arrivalAbbr;
    }

    public Date getStd() {
        return std;
    }

    public void setStd(Date std) {
        this.std = std;
    }

    public Date getSta() {
        return sta;
    }

    public void setSta(Date sta) {
        this.sta = sta;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public Date getEtd() {
        return etd;
    }

    public void setEtd(Date etd) {
        this.etd = etd;
    }

    public Date getAtd() {
        return atd;
    }

    public void setAtd(Date atd) {
        this.atd = atd;
    }

    public Date getEta() {
        return eta;
    }

    public void setEta(Date eta) {
        this.eta = eta;
    }

    public Date getAta() {
        return ata;
    }

    public void setAta(Date ata) {
        this.ata = ata;
    }

    public String getDiv1airport4code() {
        return div1airport4code;
    }

    public void setDiv1airport4code(String div1airport4code) {
        this.div1airport4code = div1airport4code;
    }

    public String getDiv2airport4code() {
        return div2airport4code;
    }

    public void setDiv2airport4code(String div2airport4code) {
        this.div2airport4code = div2airport4code;
    }

    public String getDiv1cityname() {
        return div1cityname;
    }

    public void setDiv1cityname(String div1cityname) {
        this.div1cityname = div1cityname;
    }

    public String getDiv2cityname() {
        return div2cityname;
    }

    public void setDiv2cityname(String div2cityname) {
        this.div2cityname = div2cityname;
    }

    public Short getValMadepac() {
        return valMadepac;
    }

    public void setValMadepac(Short valMadepac) {
        this.valMadepac = valMadepac;
    }

    public Short getValUploadpac() {
        return valUploadpac;
    }

    public void setValUploadpac(Short valUploadpac) {
        this.valUploadpac = valUploadpac;
    }

    public Date getBoardingtime() {
        return boardingtime;
    }

    public void setBoardingtime(Date boardingtime) {
        this.boardingtime = boardingtime;
    }

    public Date getClosingtime() {
        return closingtime;
    }

    public void setClosingtime(Date closingtime) {
        this.closingtime = closingtime;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getDep3code() {
        return dep3code;
    }

    public void setDep3code(String dep3code) {
        this.dep3code = dep3code;
    }

    public String getArr3code() {
        return arr3code;
    }

    public void setArr3code(String arr3code) {
        this.arr3code = arr3code;
    }

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public Short getCancelflight() {
        return cancelflight;
    }

    public void setCancelflight(Short cancelflight) {
        this.cancelflight = cancelflight;
    }

    public Long getCrewLinkLine() {
        return crewLinkLine;
    }

    public void setCrewLinkLine(Long crewLinkLine) {
        this.crewLinkLine = crewLinkLine;
    }

    public Long getStewLinkLine() {
        return stewLinkLine;
    }

    public void setStewLinkLine(Long stewLinkLine) {
        this.stewLinkLine = stewLinkLine;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FlightInfoEntity other = (FlightInfoEntity) that;
        return (this.getFlightInfoId() == null ? other.getFlightInfoId() == null : this.getFlightInfoId().equals(other.getFlightInfoId()))
            && (this.getFlightDate() == null ? other.getFlightDate() == null : this.getFlightDate().equals(other.getFlightDate()))
            && (this.getFlightNo() == null ? other.getFlightNo() == null : this.getFlightNo().equals(other.getFlightNo()))
            && (this.getDepartureAirport() == null ? other.getDepartureAirport() == null : this.getDepartureAirport().equals(other.getDepartureAirport()))
            && (this.getDepartureAbbr() == null ? other.getDepartureAbbr() == null : this.getDepartureAbbr().equals(other.getDepartureAbbr()))
            && (this.getArrivalAirport() == null ? other.getArrivalAirport() == null : this.getArrivalAirport().equals(other.getArrivalAirport()))
            && (this.getArrivalAbbr() == null ? other.getArrivalAbbr() == null : this.getArrivalAbbr().equals(other.getArrivalAbbr()))
            && (this.getStd() == null ? other.getStd() == null : this.getStd().equals(other.getStd()))
            && (this.getSta() == null ? other.getSta() == null : this.getSta().equals(other.getSta()))
            && (this.getAircraftType() == null ? other.getAircraftType() == null : this.getAircraftType().equals(other.getAircraftType()))
            && (this.getRegCode() == null ? other.getRegCode() == null : this.getRegCode().equals(other.getRegCode()))
            && (this.getEtd() == null ? other.getEtd() == null : this.getEtd().equals(other.getEtd()))
            && (this.getAtd() == null ? other.getAtd() == null : this.getAtd().equals(other.getAtd()))
            && (this.getEta() == null ? other.getEta() == null : this.getEta().equals(other.getEta()))
            && (this.getAta() == null ? other.getAta() == null : this.getAta().equals(other.getAta()))
            && (this.getDiv1airport4code() == null ? other.getDiv1airport4code() == null : this.getDiv1airport4code().equals(other.getDiv1airport4code()))
            && (this.getDiv2airport4code() == null ? other.getDiv2airport4code() == null : this.getDiv2airport4code().equals(other.getDiv2airport4code()))
            && (this.getDiv1cityname() == null ? other.getDiv1cityname() == null : this.getDiv1cityname().equals(other.getDiv1cityname()))
            && (this.getDiv2cityname() == null ? other.getDiv2cityname() == null : this.getDiv2cityname().equals(other.getDiv2cityname()))
            && (this.getValMadepac() == null ? other.getValMadepac() == null : this.getValMadepac().equals(other.getValMadepac()))
            && (this.getValUploadpac() == null ? other.getValUploadpac() == null : this.getValUploadpac().equals(other.getValUploadpac()))
            && (this.getBoardingtime() == null ? other.getBoardingtime() == null : this.getBoardingtime().equals(other.getBoardingtime()))
            && (this.getClosingtime() == null ? other.getClosingtime() == null : this.getClosingtime().equals(other.getClosingtime()))
            && (this.getPassengers() == null ? other.getPassengers() == null : this.getPassengers().equals(other.getPassengers()))
            && (this.getDep3code() == null ? other.getDep3code() == null : this.getDep3code().equals(other.getDep3code()))
            && (this.getArr3code() == null ? other.getArr3code() == null : this.getArr3code().equals(other.getArr3code()))
            && (this.getReleaseId() == null ? other.getReleaseId() == null : this.getReleaseId().equals(other.getReleaseId()))
            && (this.getCancelflight() == null ? other.getCancelflight() == null : this.getCancelflight().equals(other.getCancelflight()))
            && (this.getCrewLinkLine() == null ? other.getCrewLinkLine() == null : this.getCrewLinkLine().equals(other.getCrewLinkLine()))
            && (this.getStewLinkLine() == null ? other.getStewLinkLine() == null : this.getStewLinkLine().equals(other.getStewLinkLine()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFlightInfoId() == null) ? 0 : getFlightInfoId().hashCode());
        result = prime * result + ((getFlightDate() == null) ? 0 : getFlightDate().hashCode());
        result = prime * result + ((getFlightNo() == null) ? 0 : getFlightNo().hashCode());
        result = prime * result + ((getDepartureAirport() == null) ? 0 : getDepartureAirport().hashCode());
        result = prime * result + ((getDepartureAbbr() == null) ? 0 : getDepartureAbbr().hashCode());
        result = prime * result + ((getArrivalAirport() == null) ? 0 : getArrivalAirport().hashCode());
        result = prime * result + ((getArrivalAbbr() == null) ? 0 : getArrivalAbbr().hashCode());
        result = prime * result + ((getStd() == null) ? 0 : getStd().hashCode());
        result = prime * result + ((getSta() == null) ? 0 : getSta().hashCode());
        result = prime * result + ((getAircraftType() == null) ? 0 : getAircraftType().hashCode());
        result = prime * result + ((getRegCode() == null) ? 0 : getRegCode().hashCode());
        result = prime * result + ((getEtd() == null) ? 0 : getEtd().hashCode());
        result = prime * result + ((getAtd() == null) ? 0 : getAtd().hashCode());
        result = prime * result + ((getEta() == null) ? 0 : getEta().hashCode());
        result = prime * result + ((getAta() == null) ? 0 : getAta().hashCode());
        result = prime * result + ((getDiv1airport4code() == null) ? 0 : getDiv1airport4code().hashCode());
        result = prime * result + ((getDiv2airport4code() == null) ? 0 : getDiv2airport4code().hashCode());
        result = prime * result + ((getDiv1cityname() == null) ? 0 : getDiv1cityname().hashCode());
        result = prime * result + ((getDiv2cityname() == null) ? 0 : getDiv2cityname().hashCode());
        result = prime * result + ((getValMadepac() == null) ? 0 : getValMadepac().hashCode());
        result = prime * result + ((getValUploadpac() == null) ? 0 : getValUploadpac().hashCode());
        result = prime * result + ((getBoardingtime() == null) ? 0 : getBoardingtime().hashCode());
        result = prime * result + ((getClosingtime() == null) ? 0 : getClosingtime().hashCode());
        result = prime * result + ((getPassengers() == null) ? 0 : getPassengers().hashCode());
        result = prime * result + ((getDep3code() == null) ? 0 : getDep3code().hashCode());
        result = prime * result + ((getArr3code() == null) ? 0 : getArr3code().hashCode());
        result = prime * result + ((getReleaseId() == null) ? 0 : getReleaseId().hashCode());
        result = prime * result + ((getCancelflight() == null) ? 0 : getCancelflight().hashCode());
        result = prime * result + ((getCrewLinkLine() == null) ? 0 : getCrewLinkLine().hashCode());
        result = prime * result + ((getStewLinkLine() == null) ? 0 : getStewLinkLine().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", flightInfoId=").append(flightInfoId);
        sb.append(", flightDate=").append(flightDate);
        sb.append(", flightNo=").append(flightNo);
        sb.append(", departureAirport=").append(departureAirport);
        sb.append(", departureAbbr=").append(departureAbbr);
        sb.append(", arrivalAirport=").append(arrivalAirport);
        sb.append(", arrivalAbbr=").append(arrivalAbbr);
        sb.append(", std=").append(std);
        sb.append(", sta=").append(sta);
        sb.append(", aircraftType=").append(aircraftType);
        sb.append(", regCode=").append(regCode);
        sb.append(", etd=").append(etd);
        sb.append(", atd=").append(atd);
        sb.append(", eta=").append(eta);
        sb.append(", ata=").append(ata);
        sb.append(", div1airport4code=").append(div1airport4code);
        sb.append(", div2airport4code=").append(div2airport4code);
        sb.append(", div1cityname=").append(div1cityname);
        sb.append(", div2cityname=").append(div2cityname);
        sb.append(", valMadepac=").append(valMadepac);
        sb.append(", valUploadpac=").append(valUploadpac);
        sb.append(", boardingtime=").append(boardingtime);
        sb.append(", closingtime=").append(closingtime);
        sb.append(", passengers=").append(passengers);
        sb.append(", dep3code=").append(dep3code);
        sb.append(", arr3code=").append(arr3code);
        sb.append(", releaseId=").append(releaseId);
        sb.append(", cancelflight=").append(cancelflight);
        sb.append(", crewLinkLine=").append(crewLinkLine);
        sb.append(", stewLinkLine=").append(stewLinkLine);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}