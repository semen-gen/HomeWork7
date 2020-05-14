package local.SetClass;

import java.util.*;

public class SetClass {

    private final static HashSet<Card> CARDS;

    static {
        CARDS = new HashSet<>();
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

}
