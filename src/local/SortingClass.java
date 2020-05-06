package local;

import java.util.*;

public class SortingClass {

    private final static ArrayList<Pupil> pupils;

    static {
        pupils = new ArrayList<>();
    }

    public static class Pupil implements Comparable<Pupil> {

        private final String NAME;
        private final int MARK;
        private final int AGE;

        public Pupil(String name, int mark, int age) {
            NAME = name;
            MARK = mark;
            AGE = age;
            pupils.add(this);
        }

        public String getNAME() {
            return NAME;
        }

        public int getMARK() {
            return MARK;
        }

        public int getAGE() {
            return AGE;
        }

        @Override
        public int compareTo(Pupil anotherPupil) {
            return this.NAME.compareTo(anotherPupil.NAME);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(NAME).append(", ");
            sb.append("оценка ").append(MARK);
            sb.append(", возраст ").append(AGE);

            return sb.toString();
        }

    }

    public static void sortPupils() {
        Collections.sort(pupils);
    }

    public static void printPupils() {
        for (Pupil one : pupils) {
            System.out.println(one);
        }
        System.out.println();
    }

    public static ArrayList<Pupil> getPupils() {
        return pupils;
    }

}