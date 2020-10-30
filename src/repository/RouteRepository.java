package repository;

import model.Route;

import java.util.Set;

public interface RouteRepository {
    void addRoute(Route route);
    Set<Route> getAll();
    void prepareRoute(int pos);
}
