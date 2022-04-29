package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Park  implements Parking {
    private  int truckPlace;
    private  int carPassPlace;
    private  List<Transport> transportList = new ArrayList<>(truckPlace + carPassPlace);

    public Park(int truckPlace, int carPassPlace) {
        this.truckPlace = truckPlace;
        this.carPassPlace = carPassPlace;
        this.transportList = new ArrayList<>(truckPlace + carPassPlace);
    }

    @Override
    public boolean park(Transport transport) {
        boolean result = false;
        if (transport.getSize() == CarPass.SIZE && carPassPlace >= CarPass.SIZE) {
            transportList.add(transport);
            carPassPlace--;
            result = true;
        } else if (transport.getSize() > CarPass.SIZE && truckPlace >= CarPass.SIZE) {
            transportList.add(transport);
            truckPlace--;
            result = true;
        } else if (transport.getSize() > CarPass.SIZE && truckPlace == 0
        && carPassPlace >= transport.getSize()) {
            transportList.add(transport);
            carPassPlace -= transport.getSize();
            result = true;
        }
        return result;
    }
}
