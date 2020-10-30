package factory;

import model.BusCompany;

public interface BusCompanyFactory {
    BusCompany create(String name);
}
