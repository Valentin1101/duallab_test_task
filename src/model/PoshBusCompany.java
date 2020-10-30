package model;

public class PoshBusCompany implements BusCompany {

    static final String NAME = "Posh";

    @Override
    public String name() {
        return NAME;
    }
}
