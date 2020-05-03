package local;

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
    }

}
