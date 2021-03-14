package P06GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final long capacity;
    private long currentTotalQuantity;
    private long gold;
    private final Map<String, Long> cash;
    private final Map<String, Long> gems;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
    }

    public void addCash(String item, long quantity) {
        long totalGems = getTotalGems();
        long totalCash = getTotalCash();
        if (hasFreeCapacity(quantity) && totalGems >= totalCash + quantity) {
            if (!this.cash.containsKey(item)) {
                this.cash.put(item, quantity);
            } else {
                this.cash.put(item, this.cash.get(item) + quantity);
            }
            this.currentTotalQuantity += quantity;
        }
    }

    private long getTotalCash() {
        return this.cash.values().stream().mapToLong(e -> e).sum();
    }

    public void addGems(String item, long quantity) {
        long totalGems = getTotalGems();
        if (hasFreeCapacity(quantity) && totalGems + quantity <= this.gold) {
            if (!this.gems.containsKey(item)) {
                this.gems.put(item, quantity);
            } else {
                this.gems.put(item, this.gems.get(item) + quantity);
            }

            this.currentTotalQuantity += quantity;
        }
    }

    private long getTotalGems() {
        return this.gems.values().stream().mapToLong(e -> e).sum();
    }

    public void addGold(long quantity) {
        if (hasFreeCapacity(quantity)) {
            this.gold += quantity;
            this.currentTotalQuantity += quantity;
        }
    }

    public boolean hasFreeCapacity(long quantity) {
        return currentTotalQuantity + quantity <= capacity;
    }

    public void printContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<Gold> $%d", this.gold)).append(System.lineSeparator());
        sb.append(String.format("##Gold - %d", this.gold)).append(System.lineSeparator());

        if (!this.gems.isEmpty()) {
            sb.append(String.format("<Gem> $%d", getTotalGems())).append(System.lineSeparator());
            this.gems.entrySet().stream().sorted((g1, g2) -> {
                int result = g2.getKey().compareTo(g1.getKey());
                if (result == 0) {
                    result = g1.getValue().compareTo(g2.getValue());
                }
                return result;
            }).forEach(entry -> sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
                    .append(System.lineSeparator()));
        }

        if (!this.cash.isEmpty()) {
            sb.append(String.format("<Cash> $%d", getTotalCash())).append(System.lineSeparator());
            this.cash.entrySet().stream().sorted((c1, c2) -> {
                int result = c2.getKey().compareTo(c1.getKey());
                if (result == 0) {
                    result = c1.getValue().compareTo(c2.getValue());
                }
                return result;
            }).forEach(entry -> sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue()))
                    .append(System.lineSeparator()));
        }

        System.out.println(sb.toString());

    }
}
