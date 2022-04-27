package ru.job4j.ood.lsp;

import java.util.List;

public interface Parking {
    boolean park(Transport car);

    int getTruckPlace();

    int getCarPassPlace();

    List<Transport> getTransport();
}
