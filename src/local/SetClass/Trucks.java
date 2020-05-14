package local.SetClass;

import java.util.HashSet;
import java.util.Iterator;

public class Trucks {

    public final static int MAX_MASS;

    private final static HashSet<Cargo> TRUCK;

    static {
        MAX_MASS = 150;
        TRUCK = new HashSet<>();
    }

    public static class Cargo {

        private final int MASS;

        public Cargo(int mass) {
            MASS = mass;
            TRUCK.add(this);
        }

        public int getMASS() {
            return MASS;
        }

    }

    public static HashSet<Cargo> getTruck() {
        return TRUCK;
    }

    public static void checkTruck() {
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


    private static int getSumMass() {
        int sumMass = 0;
        for (Cargo cargo : TRUCK) {
            System.out.println(cargo.getMASS());
            sumMass += cargo.getMASS();
        }
        return sumMass;
    }

    private static void eliminateOverload(int overload) {
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

        TRUCK.remove(remove);
        System.out.println("Удалён груз с массой " + remove.getMASS());
        checkTruck();
    }

    private static void cargoDelivery() {
        Iterator<Cargo> i = TRUCK.iterator();

        while (i.hasNext()) {
            System.out.println("Выгружен товар с массой " + i.next().getMASS());
            i.remove();
        }
    }

}
