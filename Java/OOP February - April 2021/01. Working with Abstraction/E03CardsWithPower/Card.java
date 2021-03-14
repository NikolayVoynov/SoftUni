package E03CardsWithPower;

public class Card {
    private CardsRank cardsRank;
    private CardsSuit cardsSuit;
    private int power;

    public Card(CardsRank cardsRank, CardsSuit cardsSuit) {
        this.cardsRank = cardsRank;
        this.cardsSuit = cardsSuit;
        calculatePower();
    }

    private void calculatePower() {
        this.power = this.cardsRank.getRankPower() +this.cardsSuit.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",this.cardsRank.name(), this.cardsSuit.name(),
                this.power);
    }
}
