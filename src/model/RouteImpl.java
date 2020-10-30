package model;

import java.time.LocalTime;

public class RouteImpl implements Route {

    BusCompany busCompany;
    LocalTime departureTime;
    LocalTime arrivalTime;

    @Override
    public BusCompany busCompany() {
        return busCompany;
    }

    @Override
    public LocalTime departureTime() {
        return departureTime;
    }

    @Override
    public LocalTime arrivalTime() {
        return arrivalTime;
    }

    @Override
    public void setBusCompany(BusCompany company) {
        busCompany = company;
    }

    @Override
    public void setDepartureTime(LocalTime time) {
        departureTime = time;
    }

    @Override
    public void setArrivalTime(LocalTime time) {
        arrivalTime = time;
    }

    @Override
    public int compareTo(Route o) {
        if(o != null) {
            if (o.departureTime().equals(departureTime)) {
                return 0;
            } else if (departureTime.isBefore(o.departureTime())) {
                return -1;
            }
        }
        return 1;
    }
}
