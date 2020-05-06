package local;

import java.util.Comparator;

public class MarkComparator implements Comparator<SortingClass.Pupil> {

    @Override
    public int compare(SortingClass.Pupil p1, SortingClass.Pupil p2) {
        return p1.getMARK() > p2.getMARK() ? 1 : p1.getMARK() == p2.getMARK() ? 0 : -1;
    }

}
