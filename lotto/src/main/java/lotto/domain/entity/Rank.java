package lotto.domain.entity;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public enum Rank {
    ONE("1등", 6, false, 2000000000),
    TWO("2등", 5, true, 30000000),
    THREE("3등", 5, false, 1500000),
    FOUR("4등", 4, false, 50000),
    FIVE("5등", 3, false, 5000),
    ZERO("미당첨", 0, false, 0);

    private String name;
    private int correctCount;
    private boolean hasBonus;
    private long amount;

    Rank(String name, int correctCount, boolean hasBonus, long amount) {
        this.name = name;
        this.correctCount = correctCount;
        this.hasBonus = hasBonus;
        this.amount = amount;
    }

    public static Rank getRankByLottoCount(int correctCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(winingType -> winingType.isCorrectCount(correctCount) && winingType.hasBonus == hasBonus)
                .findFirst()
                .orElse(ZERO);
    }

    public static Map<Rank, Integer> getWiningCountEmptyMap() {
        Map<Rank, Integer> winingCounterMap = new TreeMap<>(Comparator.reverseOrder());
        for (Rank rank : values()) {
            winingCounterMap.put(rank, 0);
        }
        return winingCounterMap;
    }

    private boolean isCorrectCount(int correctCount) {
        return this.correctCount == correctCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public long getAmount() {
        return amount;
    }
}