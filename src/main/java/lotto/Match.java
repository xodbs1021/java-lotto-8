package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.staticWord.*;

public class Match {
    private LottoResult result;
    private int bonus;
    private Lotto lotto;

    public Match(LottoResult lr, int bonus, Lotto lotto) {
        this.result = lr;
        this.bonus = bonus;
        this.lotto = lotto;
    }

    private static Map<String,Integer> initializeResultMap() {
        Map<String, Integer> total = new HashMap<>();
        total.put(FIFTH.getValue(), 0);
        total.put(FOURTH.getValue(), 0);
        total.put(THIRD.getValue(), 0);
        total.put(SECOND.getValue(), 0);
        total.put(FIRST.getValue(), 0);
        return total;
    }

    private void calculateWinnings(Map<String, Integer> total) {
        for(List<Integer> purchasedLotto : result.numbers) {
            int matchCount = (int) purchasedLotto.stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            boolean bonusMatch = purchasedLotto.contains(bonus);

            updateTotalWinnings(total, matchCount, bonusMatch);
        }
    }
