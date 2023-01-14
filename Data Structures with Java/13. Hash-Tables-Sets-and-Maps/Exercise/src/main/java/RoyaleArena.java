import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class RoyaleArena implements IArena {
    private Map<Integer, Battlecard> cardsByIds;
    private Map<CardType, Set<Battlecard>> cardsByTypes;

    public RoyaleArena() {
        this.cardsByIds = new HashMap<>();
        this.cardsByTypes = new HashMap<>();
    }

    @Override
    public void add(Battlecard card) {
        this.cardsByIds.putIfAbsent(card.getId(), card);
        this.cardsByTypes.putIfAbsent(card.getType(), new TreeSet<>(Battlecard::compareTo));
        this.cardsByTypes.get(card.getType()).add(card);
    }

    @Override
    public boolean contains(Battlecard card) {
        return this.cardsByIds.containsKey(card.getId());
    }

    @Override
    public int count() {
        return this.cardsByIds.size();
    }

    @Override
    public void changeCardType(int id, CardType type) {
        Battlecard battlecard = this.cardsByIds.get(id);

        if (battlecard == null) {
            throw new IllegalArgumentException("No card with id: " + id);
        }

        battlecard.setType(type);
    }

    @Override
    public Battlecard getById(int id) {
        Battlecard battlecard = this.cardsByIds.get(id);

        if (battlecard == null) {
            throw new UnsupportedOperationException();
        }

        return battlecard;
    }

    @Override
    public void removeById(int id) {
        Battlecard battlecard = this.cardsByIds.remove(id);

        if (battlecard == null) {
            throw new UnsupportedOperationException();
        }

        this.cardsByTypes.get(battlecard.getType()).remove(battlecard);
    }

    @Override
    public Iterable<Battlecard> getByCardType(CardType type) {
        return getBattlecardsByType(type);
    }

    @Override
    public Iterable<Battlecard> getByTypeAndDamageRangeOrderedByDamageThenById(CardType type, int lo, int hi) {
        Set<Battlecard> battlecards = getBattlecardsByType(type);

        return battlecards
                .stream()
                .filter(c -> c.getDamage() >= lo && c.getDamage() < hi)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Battlecard> getByCardTypeAndMaximumDamage(CardType type, double damage) {
        Set<Battlecard> battlecards = getBattlecardsByType(type);

        List<Battlecard> result = battlecards
                .stream()
                .filter(c -> c.getDamage() <= damage)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return result;
    }

    @Override
    public Iterable<Battlecard> getByNameOrderedBySwagDescending(String name) {
        List<Battlecard> battlecards = getBattlecardsByPredicate(c -> c.getName().equals(name));

        if (battlecards.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        battlecards.sort(Comparator.comparingDouble(Battlecard::getSwag).reversed());

        return battlecards;
    }

    @Override
    public Iterable<Battlecard> getByNameAndSwagRange(String name, double lo, double hi) {
        List<Battlecard> battlecards =
                getBattlecardsByPredicate(c -> c.getDamage() >= lo && c.getDamage() < hi && c.getName().equals(name));

        if (battlecards.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        battlecards.sort(Comparator.comparingDouble(Battlecard::getSwag).reversed().thenComparing(Battlecard::getId));

        return battlecards;
    }

    @Override
    public Iterable<Battlecard> getAllByNameAndSwag() {
        return null;
    }

    @Override
    public Iterable<Battlecard> findFirstLeastSwag(int n) {
        return null;
    }

    @Override
    public Iterable<Battlecard> getAllInSwagRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterator<Battlecard> iterator() {
        return null;
    }

    private Set<Battlecard> getBattlecardsByType(CardType type) {
        Set<Battlecard> battlecards = this.cardsByTypes.get(type);

        if (battlecards == null) {
            throw new UnsupportedOperationException();
        }

        return battlecards;
    }

    private List<Battlecard> getBattlecardsByPredicate(Predicate<Battlecard> predicate) {
        List<Battlecard> battlecards = new ArrayList<>();

        for (Battlecard battlecard : cardsByIds.values()) {
            if (predicate.test(battlecard)) {
                battlecards.add(battlecard);
            }
        }
        return battlecards;
    }

}
