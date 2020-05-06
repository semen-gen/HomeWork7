package local;

import java.util.*;

public class ListClass {

    private LinkedList<Integer> list;
    private ArrayList<Integer> jenga;

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

    public ArrayList<Integer> fillInJenga(int length) {
        jenga = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            jenga.add(i);
        }

        return jenga;
    }

    public void printJengaGame() {
        for (int i = 0; i < jenga.size(); i++) {
            int index = (int) (Math.random() * (jenga.size() - 2) + 1);
            jenga.add(jenga.remove(index));
        }
        System.out.println(jenga);
    }

}
