package local;

import java.util.*;

public class SetClass {

    public final static int MAX_MASS;

    private final static HashSet<Card> CARDS;
    private final static HashSet<Cargo> TRUCK;

    static {
        MAX_MASS = 150;
        CARDS = new HashSet<>();
        TRUCK = new HashSet<>();
    }


    public static class Card {

        private final int NUMBER;

        public Card(int number) {
            NUMBER = number;
            CARDS.add(this);
        }

        public int getNumber() {
            return NUMBER;
        }

        @Override
        public String toString() {
            return String.valueOf(getNumber());
        }

    }

    public static HashSet<Card> getCards() {
        return CARDS;
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
        int sumMass = 0;
        Cargo item;

        for (Cargo cargo : TRUCK) {
            item = cargo;
            System.out.println(item.getMASS());
            sumMass += item.getMASS();
        }
        System.out.println("Суммарная масса грузов " + sumMass);

        if (sumMass > MAX_MASS) {
            int overload = sumMass - MAX_MASS;
            System.out.println("Перегруз на " + overload);
            higher(overload);
        }
        else {
            System.out.println("Отправляем грузовик");
            ceiling();
        }

    }

    private static void higher(int overload) {
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

    private static void ceiling() {
        Iterator<Cargo> i = TRUCK.iterator();

        while (i.hasNext()) {
            System.out.println("Выгружен товар с массой " + i.next().getMASS());
            i.remove();
        }
    }

}
