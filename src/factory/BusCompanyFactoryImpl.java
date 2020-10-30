package factory;

import model.BusCompany;
import model.GrottyBusCompany;
import model.PoshBusCompany;

public class BusCompanyFactoryImpl implements BusCompanyFactory {

    @Override
    public BusCompany create(String name) {
        if(name.equals("Posh")) {
            return new PoshBusCompany();
        } else if(name.equals("Grotty")) {
            return new GrottyBusCompany();
        }
        return null;
    }
}
