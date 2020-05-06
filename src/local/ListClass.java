package local;

import java.util.*;

public class ListClass {

    private LinkedList<Integer> list;

    public LinkedList<Integer> fillInList(int length) {
        list = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) list.addFirst(i);
            else list.addLast(i);
        }
        return list;
    }

    public void printGetList() {
        int i = 0;
        System.out.print("[");
        while (list.size() > 0) {
            if (i % 2 == 0) System.out.print(list.pollLast() + ", ");
            else System.out.print(list.pollFirst() + ", ");
            i++;
        }
        System.out.println("\b\b]");
    }

}
