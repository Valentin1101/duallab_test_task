package factory;

import model.Route;

public interface RouteFactory {
    Route create(String service);
}
