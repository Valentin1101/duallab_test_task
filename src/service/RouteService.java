package service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface RouteService {
    void addRoute(String service);
    void loadFromFile(String filename) throws FileNotFoundException;
    void writeToFile(String filename) throws IOException;
}
