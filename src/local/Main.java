package local;

import local.SetClass.SetClass;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        DequeClass hospital = new DequeClass(5);
        int counter = 0;

        System.out.println("Очередь в поликлинике");
        while (hospital.getQueue().size() > 0) {
            counter++;
            if (DequeClass.currentIndex < hospital.MAX_VISITOR) hospital.getQueue().add(++DequeClass.currentIndex);
            if (counter % 3 == 0) hospital.printPatient(hospital.getQueue().pollLast().toString() + " без очереди");
            else hospital.printPatient(hospital.getQueue().poll().toString());
        }
        System.out.println();

        System.out.println("Гонка на выбывание");
        DequeClass race = new DequeClass(20);
        race.printRaceOut();
        System.out.println();

        System.out.println("Список в котором добавляем элементы поочередно в начало и конец списка");
        ListClass listClass = new ListClass();
        System.out.println(listClass.fillInList(6));
        listClass.printGetList();
        System.out.println();

        System.out.println("Игра Дженга");
        System.out.println(listClass.fillInJenga(20));
        listClass.printJengaGame();
        System.out.println();

        System.out.println("Список кредитных карточек");
        SetClass.Card card1 = new SetClass.Card(5457);
        SetClass.Card card2 = new SetClass.Card(5478);
        SetClass.Card card3 = new SetClass.Card(5459);
        System.out.println(SetClass.getCards());
        System.out.println();

        System.out.println("Список грузов");
        SetClass.Cargo cargo1 = new SetClass.Cargo(15);
        SetClass.Cargo cargo2 = new SetClass.Cargo(25);
        SetClass.Cargo cargo3 = new SetClass.Cargo(20);
        SetClass.Cargo cargo4 = new SetClass.Cargo(100);
        SetClass.checkTruck();
        System.out.println();

        System.out.println("Соц сеть");
        MapClass.register("semen_gen", "Иван");
        MapClass.register("zayka", "Оля");
        MapClass.register("zver", "Лёха");
        MapClass.register("zver", "Лёха");
        MapClass.register("sen-sey", "Степан");
        MapClass.unRegister("zayka");
        System.out.println(MapClass.getUsers());
        System.out.println();

        System.out.println("Список учеников");
        new SortingClass.Pupil("Вася Петечкин", 5, 10);
        new SortingClass.Pupil("Оля Ватрушкина", 3, 11);
        new SortingClass.Pupil("Гена Лопух", 5, 12);
        new SortingClass.Pupil("Дима Косяк", 2, 10);
        new SortingClass.Pupil("Федя Рашпиль", 4, 11);

        SortingClass.printPupils();
        Collections.sort(SortingClass.getPupils());
        SortingClass.printPupils();
        MarkComparator mc = new MarkComparator();
        SortingClass.getPupils().sort(mc);
        SortingClass.printPupils();
        AgeComparator ac = new AgeComparator();
        SortingClass.getPupils().sort(ac);
        SortingClass.printPupils();
    }

}
