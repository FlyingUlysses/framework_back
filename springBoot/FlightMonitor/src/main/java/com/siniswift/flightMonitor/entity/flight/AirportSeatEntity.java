package com.siniswift.flightMonitor.entity.flight;

import java.io.Serializable;

/**
 * AIRPORT_SEAT
 * @author 
 */
public class AirportSeatEntity implements Serializable {
    private String airportSeatId;

    private String airportId;

    private String seatId;

    private static final long serialVersionUID = 1L;

    public String getAirportSeatId() {
        return airportSeatId;
    }

    public void setAirportSeatId(String airportSeatId) {
        this.airportSeatId = airportSeatId;
    }

    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}