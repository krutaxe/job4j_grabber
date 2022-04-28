package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Park  implements Parking {
    private  int truckPlace;
    private  int carPassPlace;
    private  List<Transport> transportList = new ArrayList<>();

    public Park(int truckPlace, int carPassPlace) {
        this.truckPlace = truckPlace;
        this.carPassPlace = carPassPlace;
    }

        @Override
    public boolean park(Transport transport) {
        boolean result = false;
        if (transport.getSize() == 1 && carPassPlace >= 1) {
            transportList.add(transport);
            carPassPlace--;
            result = true;
        } else if (transport.getSize() > 1 && truckPlace >= 1) {
            transportList.add(transport);
            truckPlace--;
            result = true;
        } else if (transport.getSize() > 1 && truckPlace == 0
            && transport.getSize() <= carPassPlace) {
            transportList.add(transport);
            carPassPlace -= transport.getSize();
            result = true;
        }
        return result;
    }
}
