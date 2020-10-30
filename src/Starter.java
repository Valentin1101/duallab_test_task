import factory.BusCompanyFactoryImpl;
import factory.RouteFactory;
import factory.RouteFactoryImpl;
import repository.RouteRepository;
import repository.RouteRepositoryImpl;
import service.RouteService;
import service.RouteServiceImpl;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {
        String path;
        if(args.length == 1) {
            path = args[0];
        } else {
            System.out.print("Specify the path to the input file. Example: java Starter input.txt");
            return;
        }

        RouteFactory factory = new RouteFactoryImpl(new BusCompanyFactoryImpl());
        RouteRepository repository = new RouteRepositoryImpl();
        RouteService service = new RouteServiceImpl(repository, factory);

        service.loadFromFile(path);
        repository.prepareRoute(0);
        service.writeToFile("output.txt");
    }
}
