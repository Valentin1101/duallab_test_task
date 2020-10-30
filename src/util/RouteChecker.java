package util;

import model.Route;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class RouteChecker {

    private RouteChecker() {}

    public static boolean less1hour(Route route) {
        LocalTime depart = route.departureTime();
        LocalTime arrival = route.arrivalTime();
        return ChronoUnit.MINUTES.between(depart, arrival) <= 60;
    }

    public static Route effectiveRoute(Route route1, Route route2) {
        LocalTime depart1Route = route1.departureTime();
        LocalTime arrival1Route = route1.arrivalTime();

        LocalTime depart2Route = route2.departureTime();
        LocalTime arrival2Route = route2.arrivalTime();

        if(depart1Route.equals(depart2Route) && arrival1Route.equals(arrival2Route)) {
            if(route1.busCompany().name().equals("Posh")) {
                return route1;
            }
            return route2;
        }

        if(depart1Route.equals(depart2Route) && arrival1Route.isBefore(arrival2Route)) {
            return route1;
        } else if(depart2Route.equals(depart1Route) && arrival2Route.isBefore(arrival1Route)) {
            return route2;
        }

        if(arrival1Route.equals(arrival2Route) && depart1Route.isAfter(depart2Route)) {
            return route1;
        } else if(arrival2Route.equals(arrival1Route) && depart2Route.isAfter(depart1Route)) {
            return route2;
        }

        if(depart1Route.isAfter(depart2Route) && arrival1Route.isBefore(arrival2Route)) {
            return route1;
        } else if(depart2Route.isAfter(depart1Route) && arrival2Route.isBefore(arrival1Route)) {
            return route2;
        }

        return null;
    }
}
