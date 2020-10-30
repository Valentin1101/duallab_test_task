package repository;

import model.Route;
import util.RouteChecker;

import java.util.Set;
import java.util.TreeSet;

public class RouteRepositoryImpl implements RouteRepository {

    Set<Route> routes;

    public RouteRepositoryImpl() {
        routes = new TreeSet<>();
    }

    @Override
    public void addRoute(Route route) {
        if(route != null && RouteChecker.less1hour(route))
            routes.add(route);
    }

    public void prepareRoute(int pos) {
        Object[] arr = routes.toArray();
        if(pos < arr.length && pos+1 < arr.length) {
            Route current = (Route) arr[pos];
            Route next = (Route) arr[pos+1];
            Route effective = RouteChecker.effectiveRoute(current, next);
            if(effective == current) {
                routes.remove(next);
            } else if(effective == next) {
                routes.remove(current);
            }
            prepareRoute(pos+1);
        }
    }

    public Set<Route> getAll() {
        return routes;
    }
}
