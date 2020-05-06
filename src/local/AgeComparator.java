package local;

import java.util.Comparator;

public class AgeComparator implements Comparator<SortingClass.Pupil> {

    @Override
    public int compare(SortingClass.Pupil p1, SortingClass.Pupil p2) {
        return Integer.compare(p1.getAGE(), p2.getAGE());
    }

}
