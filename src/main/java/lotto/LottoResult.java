package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoResult {
    private int number;
    private Lotto lotto;
    private int bonus;
    public LottoResult(int number,Lotto lotto,int bonus) {
        this.number = number%1000;
        this.lotto = lotto;
        this.bonus = bonus;
    }
    public void run() {
        List<Integer>[] array = resultPick();

    }

    private List<Integer>[] resultPick() {
        List<Integer>[] array = new List[number];
        for (int i = 0; i < number; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        return array;
    }
}
