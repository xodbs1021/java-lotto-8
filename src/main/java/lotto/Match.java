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

    private static void updateTotalWinnings(Map<String, Integer> total, int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            total.merge(FIRST.getValue(), 1, Integer::sum);
            return;
        }

        if (matchCount == 5) {
            if (bonusMatch) {
                total.merge(SECOND.getValue(), 1, Integer::sum);
                return;
            }
            total.merge(THIRD.getValue(), 1, Integer::sum);
            return;
        }

        if (matchCount == 4) {
            total.merge(FOURTH.getValue(), 1, Integer::sum);
            return;
        }

        if (matchCount == 3) {
            total.merge(FIFTH.getValue(), 1, Integer::sum);
            return;
        }
    }

    private void printResult(Map<String, Integer> total) {
        System.out.println("당첨통계\n---");
        System.out.println();

        printRankResult(total, FIFTH);
        printRankResult(total, FOURTH);
        printRankResult(total, THIRD);
        printBonusRankResult(total, SECOND);
        printRankResult(total, FIRST);

        double profitRate = calculateProfitRate(total);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

