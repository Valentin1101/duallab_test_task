package model;

import java.time.LocalTime;

public interface Route extends Comparable<Route> {

    BusCompany busCompany();

    LocalTime departureTime();
    LocalTime arrivalTime();

    void setBusCompany(BusCompany company);
    void setDepartureTime(LocalTime time);
    void setArrivalTime(LocalTime time);

}
