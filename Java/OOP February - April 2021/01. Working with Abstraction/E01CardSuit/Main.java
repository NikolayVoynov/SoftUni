package E01CardSuit;

public class Main {
    public static void main(String[] args) {

        CardsSuit[] cardsSuits = CardsSuit.values();

        StringBuilder builderCardsSuit = new StringBuilder("Card Suits:");

        for (CardsSuit cardsSuit : cardsSuits) {
            builderCardsSuit.append(System.lineSeparator()).append(String.format("Ordinal value: %d; Name value: %s",cardsSuit.ordinal(), cardsSuit.name()));
        }

        System.out.print(builderCardsSuit);

    }
}
