package local;

import java.util.Deque;
import java.util.LinkedList;

public class DequeClass {

    public final int MAX_VISITOR = 30;
    public static int currentIndex;

    private Deque<Integer> queue;

    public DequeClass(int currentIndex) {
        DequeClass.currentIndex = currentIndex;
        queue = new LinkedList<>();

        for (int i = 1; i <= currentIndex; i++) {
            queue.add(i);
        }
    }

    public Deque<Integer> getQueue() {
        return queue;
    }

    public void printPatient(String patient) {
        System.out.println("Пациент № " + patient);
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
