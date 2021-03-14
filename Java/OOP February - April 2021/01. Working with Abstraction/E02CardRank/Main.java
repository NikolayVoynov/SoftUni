package E02CardRank;

public class Main {
    public static void main(String[] args) {

        CardsRank[] cardsRanks = CardsRank.values();

        StringBuilder buildCardsRank = new StringBuilder("Card Ranks:");

        for (CardsRank cardsRank : cardsRanks) {
            buildCardsRank.append(System.lineSeparator())
                    .append(String.format("Ordinal value: %d; Name value: %s", cardsRank.ordinal(), cardsRank.name()));
        }

        System.out.print(buildCardsRank);
    }
}
