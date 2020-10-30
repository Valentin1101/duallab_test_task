package service;

import factory.RouteFactory;
import model.PoshBusCompany;
import model.Route;
import repository.RouteRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RouteServiceImpl implements RouteService {

    RouteRepository repository;
    RouteFactory factory;

    public RouteServiceImpl(RouteRepository repository, RouteFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public void addRoute(String service) {
        Route route = factory.create(service);
        if(route != null) {
            repository.addRoute(route);
        }
    }

    public void writeToFile(String filename) throws IOException {

        StringBuilder poshTimetable = new StringBuilder();
        StringBuilder grottyTimetable = new StringBuilder();

        for (Route route: repository.getAll()) {
            if(route.busCompany() instanceof PoshBusCompany) {
                poshTimetable.append(String.format("%s %s %s%n",
                        route.busCompany().name(),
                        route.departureTime(),
                        route.arrivalTime()));
            } else {
                grottyTimetable.append(String.format("%s %s %s%n",
                        route.busCompany().name(),
                        route.departureTime(),
                        route.arrivalTime()));
            }
        }

        poshTimetable.append("\n");
        poshTimetable.append(grottyTimetable);

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(poshTimetable.toString().trim());
        }
        System.out.println("done.");
    }

    public void loadFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNext()) {
            String serv = scanner.nextLine();
            addRoute(serv);
        }
        scanner.close();
    }
}
