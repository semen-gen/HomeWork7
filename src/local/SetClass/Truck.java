package local.SetClass;

import java.util.HashSet;
import java.util.Iterator;

public class Truck {

    private final int MAX_MASS;

    private final HashSet<Cargo> CARGOS;


    public Truck(int maxMass, HashSet<Cargo> cargos) {
        MAX_MASS = maxMass;
        CARGOS = cargos;
    }

    public static class Cargo {

        private final int MASS;

        public Cargo(int mass) {
            MASS = mass;
        }

        public int getMASS() {
            return MASS;
        }

    }

    public HashSet<Cargo> getTruck() {
        return CARGOS;
    }

    public void checkTruck() {
        int sumMass = getSumMass();
        System.out.println("Суммарная масса грузов " + sumMass);

        if (sumMass > MAX_MASS) {
            int overload = sumMass - MAX_MASS;
            System.out.println("Перегруз на " + overload);
            eliminateOverload(overload);
        }
        else {
            System.out.println("Отправляем грузовик");
            cargoDelivery();
        }
    }


    private int getSumMass() {
        int sumMass = 0;
        for (Cargo cargo : CARGOS) {
            System.out.println(cargo.getMASS());
            sumMass += cargo.getMASS();
        }
        return sumMass;
    }

    private void eliminateOverload(int overload) {
        Cargo minCargo = null, maxCargo = null, remove;
        for (Cargo item : getTruck()) {
            if (item.getMASS() >= overload) {
                if (minCargo == null) minCargo = item;
                else if (minCargo.getMASS() > item.getMASS()) minCargo = item;
            }

            if (maxCargo == null) maxCargo = item;
            else if (maxCargo.getMASS() < item.getMASS()) maxCargo = item;
        }

        if (minCargo != null) remove = minCargo;
        else remove = maxCargo;

        CARGOS.remove(remove);
        System.out.println("Удалён груз с массой " + remove.getMASS());
        checkTruck();
    }

    private void cargoDelivery() {
        Iterator<Cargo> i = CARGOS.iterator();

        while (i.hasNext()) {
            System.out.println("Выгружен товар с массой " + i.next().getMASS());
            i.remove();
        }
    }

}
