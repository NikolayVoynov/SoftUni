import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BoardImpl implements Board {
    private Map<String, Card> deckCards;

    public BoardImpl() {
        this.deckCards = new HashMap<>();
    }

    @Override
    public void draw(Card card) {
        boolean exist = contains(card.getName());

        if (exist) {
            throw new IllegalArgumentException();
        } else {
            this.deckCards.put(card.getName(), card);
        }

    }

    @Override
    public Boolean contains(String name) {
        return this.deckCards.containsKey(name);
    }

    @Override
    public int count() {
        return this.deckCards.size();
    }

    @Override
    public void play(String attackerCardName, String attackedCardName) {
        if (!contains(attackerCardName) || !contains(attackedCardName)) {
            throw new IllegalArgumentException();
        }

        Card attacker = this.deckCards.get(attackerCardName);
        Card attacked = this.deckCards.get(attackedCardName);

        if (attacker.getLevel() == attacked.getLevel()) {
            if (attacked.getHealth() > 0) {
                attacked.setHealth(attacked.getHealth() - attacker.getDamage());

                if (attacked.getHealth() <= 0) {
                    attacker.setScore(attacker.getScore() + attacked.getLevel());
                }
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void remove(String name) {
        if (!contains(name)) {
            throw new IllegalArgumentException();
        }

        this.deckCards.remove(name);
    }

    @Override
    public void removeDeath() {
        for (Card card : deckCards.values()) {
            if (card.getHealth() <= 0) {
                this.deckCards.remove(card.getName());
            }
        }
    }

    @Override
    public Iterable<Card> getBestInRange(int start, int end) {
        return this.deckCards
                .values()
                .stream()
                .filter(c -> c.getScore() >= start && c.getScore() <= end)
                .sorted((c1, c2) -> Integer.compare(c2.getLevel(), c1.getLevel()))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Card> listCardsByPrefix(String prefix) {
        return this.deckCards
                .values()
                .stream()
                .filter(c -> c.getName().startsWith(prefix))
                .sorted((c1, c2) -> {
                            int result = Integer.compare(c1.asciiCodeReversedName(c1.getName()), c2.asciiCodeReversedName(c2.getName()));

                            if (result == 0) {
                                result = Integer.compare(c1.getLevel(), c2.getLevel());
                            }

                            return result;
                        }
                )
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Card> searchByLevel(int level) {
        return this.deckCards
                .values()
                .stream()
                .filter(c -> c.getLevel() == level)
                .sorted((c1, c2) -> Integer.compare(c2.getScore(), c1.getScore()))
                .collect(Collectors.toList());
    }

    @Override
    public void heal(int health) {
        int smallestHealth = Integer.MAX_VALUE;
        Card cardWithSmallestHealth = null;

        for (Card card : deckCards.values()) {
            if (card.getHealth() < smallestHealth) {
                smallestHealth = card.getHealth();
                cardWithSmallestHealth = card;
            }
        }

        if (cardWithSmallestHealth != null) {
            cardWithSmallestHealth.setHealth(cardWithSmallestHealth.getHealth() + health);
        }
    }
}
