package factory;

import model.BusCompany;
import model.Route;
import model.RouteImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class RouteFactoryImpl implements RouteFactory {

    BusCompanyFactory busCompanyFactory;

    public RouteFactoryImpl(BusCompanyFactory busCompanyFactory) {
        this.busCompanyFactory = busCompanyFactory;
    }

    @Override
    public Route create(String service) {
        BusCompany company = getBusCompany(service);
        LocalTime departure = getDepartureTime(service);
        LocalTime arrival = getArrivalTime(service);

        if(company != null && departure != null && arrival != null) {
            RouteImpl route = new RouteImpl();
            route.setBusCompany(company);
            route.setDepartureTime(departure);
            route.setArrivalTime(arrival);
            return route;
        }
        return null;
    }

    private BusCompany getBusCompany(String service) {
        if(service.startsWith("Posh")) {
            return busCompanyFactory.create("Posh");
        } else if (service.startsWith("Grotty")) {
            return busCompanyFactory.create("Grotty");
        }
        return null;
    }

    private LocalTime getDepartureTime(String service) {
        int first = service.indexOf(" ");
        return getLocalTime(service, first);
    }

    private LocalTime getArrivalTime(String service) {
        int last = service.lastIndexOf(" ");
        return getLocalTime(service, last);
    }

    private LocalTime getLocalTime(String service, int position) {
        String time;
        try {
            time = service.substring(position+1, position+6);
            return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (IndexOutOfBoundsException | DateTimeParseException e) {
            System.out.println(service + " this line is wrong");
        }

        return null;
    }
}
