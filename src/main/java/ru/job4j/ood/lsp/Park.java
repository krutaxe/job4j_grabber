package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Park  implements Parking {

    private  int truckPlace;
    private  int carPassPlace;
    private  List<Transport> transports = new ArrayList<>();

    public Park(int truckPlace, int carPassPlace) {
        this.truckPlace = truckPlace;
        this.carPassPlace = carPassPlace;
    }

    @Override
    public boolean park(Transport car) {
        return false;
    }

    @Override
    public int getTruckPlace() {
        return 0;
    }

    @Override
    public int getCarPassPlace() {
        return 0;
    }

    @Override
    public List<Transport> getTransport() {
        return null;
    }
}
